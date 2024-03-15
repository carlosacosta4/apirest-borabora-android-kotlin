package pe.borabora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.borabora.entity.Delivery;
import pe.borabora.entity.PickUp;
import pe.borabora.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/pickup")
    public ResponseEntity<String> createPickUpOrder(@RequestBody PickUp pickUp) {
        orderService.createPickUpOrder(pickUp.getDate(), pickUp.getHeadquarter());
        return ResponseEntity.ok("Pickup order created successfully");
    }

    @PostMapping("/delivery")
    public ResponseEntity<String> createDeliveryOrder(@RequestBody Delivery delivery) {
        orderService.createDeliveryOrder(delivery.getAddress(),
                delivery.getDate(),
                delivery.getDepartment(),
                delivery.getDistrict(),
                delivery.getProvince(),
                delivery.getUbigeo());
        return ResponseEntity.ok("Delivery order created successfully");
    }
}
