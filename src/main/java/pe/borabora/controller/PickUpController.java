package pe.borabora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.borabora.dto.PickupDTO;
import pe.borabora.entity.PickUp;
import pe.borabora.service.PickUpService;

@RestController
@RequestMapping("/order")
public class PickUpController {
    @Autowired
    private PickUpService pickUpService;

    @PostMapping("/pickUp")
    public ResponseEntity<PickUp> createPickUpOrder(@RequestBody PickupDTO pickUpDTO) {
        PickUp pickUp = pickUpService.createPickUpOrder(pickUpDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pickUp);
    }
}
