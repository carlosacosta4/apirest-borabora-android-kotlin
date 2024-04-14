package pe.borabora.controller;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.borabora.entity.*;
import pe.borabora.repository.*;
import pe.borabora.service.PurchaseService;

import java.util.NoSuchElementException;

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



    @PostMapping("/{orderType}")
    @Transactional
    public ResponseEntity<Purchase> createPurchase(@PathVariable String orderType, @RequestBody Purchase purchase) {
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

        return ResponseEntity.ok(savedPurchase);
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
}










