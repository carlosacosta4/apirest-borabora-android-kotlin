package pe.borabora.controller;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.borabora.dto.response.ApiResponse;
import pe.borabora.entity.*;
import pe.borabora.repository.*;
import pe.borabora.service.PurchaseService;
import pe.borabora.dto.response.PurchasetResponse;



@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TypeOrderRepository typeOrderRepository;
    @Autowired
    private HeadquarterRepository headquarterRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private PickUpRepository pickUpRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private PaymentGatewayRepository paymentGatewayRepository;

    @Autowired
    private CardTypeRepository cardTypeRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseProductRepository purchaseProductRepository;

    @Autowired
    private EntityManager entityManager;
    
    @Autowired
    private PurchaseService purchaseService;



    @PostMapping("/{orderType}")
    @Transactional
    public ResponseEntity<ApiResponse> createPurchase(@PathVariable String orderType, @RequestBody Purchase purchase) {
        TypeOrder typeOrder = purchase.getOrder();

        if (orderType.equalsIgnoreCase("PICKUP")) {
            typeOrder = createPickUpOrder((PickUp) typeOrder);
        } else if (orderType.equalsIgnoreCase("DELIVERY")) {
            typeOrder = createDeliveryOrder((Delivery) typeOrder);
        }

        typeOrder = typeOrderRepository.save(typeOrder);

        purchase.setOrder(typeOrder);

        PaymentGateway savedPaymentGateway = paymentGatewayRepository.save(purchase.getPayment());
        purchase.setPayment(savedPaymentGateway);

        // Guardar la compra en la base de datos antes de guardar los PurchaseProduct
        Purchase savedPurchase = purchaseRepository.save(purchase);

        // Guardar cada PurchaseProduct en la base de datos
        for (PurchaseProduct purchaseProduct : purchase.getPurchaseProducts()) {
            purchaseProduct.setPurchase(savedPurchase);
            purchaseProductRepository.save(purchaseProduct);
        }

        // Crear una nueva ApiResponse con un mensaje y un código de estado
        ApiResponse apiResponse = new ApiResponse("Compra creada con éxito", HttpStatus.OK.value());

        return ResponseEntity.ok(apiResponse);
    }

    private PickUp createPickUpOrder(PickUp pickUp) {
        // Buscar el headquarter existente en la base de datos
        Headquarter headquarter = headquarterRepository.findById(pickUp.getHeadquarter().getCod_headquarter()).orElse(null);
        if (headquarter != null) {
            pickUp.setHeadquarter(headquarter);
            pickUpRepository.save(pickUp);
        }

        return pickUp;
    }

    private Delivery createDeliveryOrder(Delivery delivery) {
        // Buscar el district existente en la base de datos
        District district = districtRepository.findById(delivery.getDistrict().getCod_district()).orElse(null);
        if (district != null) {
            delivery.setDistrict(district);
            deliveryRepository.save(delivery);
        }

        return delivery;
    }


		@GetMapping("/all/{identityDoc}")
		public ResponseEntity<List<PurchasetResponse>> getAllPurchases(@PathVariable Integer identityDoc){
		    List<PurchasetResponse> purchaseDTOS = purchaseService.getAllPurchases(identityDoc);
		    return new ResponseEntity<>(purchaseDTOS, HttpStatus.OK);
}
		
		@GetMapping("/{purchase_id}")
		public ResponseEntity<PurchasetResponse> getPurchaseById(@PathVariable Integer purchase_id){
		    Optional<Purchase> purchaseOptional = purchaseRepository.findById(purchase_id);
		    if (purchaseOptional.isPresent()) {
		        Purchase purchase = purchaseOptional.get();
		        PurchasetResponse purchaseDTO = new PurchasetResponse();
		        purchaseDTO.setPurchase_id(purchase.getPurchase_id());
		        purchaseDTO.setTotal(purchase.getTotal());
		        purchaseDTO.setIgv(purchase.getIgv());
		        purchaseDTO.setSubtotal(purchase.getSubtotal());
		        purchaseDTO.setPurchaseDate(purchase.getPurchaseDate());
		        purchaseDTO.setPaymentId(purchase.getPayment().getPayment_id());
		        purchaseDTO.setIdentityDoc(purchase.getUser().getIdentityDoc());
		        purchaseDTO.setOrderType(purchase.getOrder().getType_order_id().toString());
		        purchaseDTO.setProductIds(purchase.getProducts().stream().map(Product::getId_product).collect(Collectors.toList()));
		        return new ResponseEntity<>(purchaseDTO, HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		}
}










