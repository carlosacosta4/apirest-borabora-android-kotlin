package pe.borabora.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.borabora.entity.*;
import pe.borabora.repository.*;
import pe.borabora.service.PurchaseService;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    //---GRUPO 01
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


    @PostMapping("/order")
    @Transactional
    public TypeOrder createOrder(@RequestParam String orderType, @RequestBody TypeOrder typeOrder) {
        if (orderType.equalsIgnoreCase("PICKUP")) {
            typeOrder = createPickUpOrder((PickUp) typeOrder);
        } else if (orderType.equalsIgnoreCase("DELIVERY")) {
            typeOrder = createDeliveryOrder((Delivery) typeOrder);
        }
        return typeOrderRepository.save(typeOrder);
    }

    private PickUp createPickUpOrder(PickUp pickUp) {
        Headquarter headquarter = new Headquarter();
        // Establecer los datos de headquarter a partir de pickUp
        headquarterRepository.save(headquarter);

        pickUp.setHeadquarter(headquarter);
        pickUpRepository.save(pickUp);

        return pickUp;
    }

    private Delivery createDeliveryOrder(Delivery delivery) {
        District district = new District();
        // Establecer los datos de district a partir de delivery
        districtRepository.save(district);

        delivery.setDistrict(district);
        deliveryRepository.save(delivery);

        return delivery;
    }

    @PostMapping("/paymentGateway")
    public ResponseEntity<PaymentGateway> createPaymentGateway(@RequestBody PaymentGateway paymentGateway) {
        PaymentGateway savedPaymentGateway = paymentGatewayRepository.save(paymentGateway);
        return ResponseEntity.ok(savedPaymentGateway);
    }


}






