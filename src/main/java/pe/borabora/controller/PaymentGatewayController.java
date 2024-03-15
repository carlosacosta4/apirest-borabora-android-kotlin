package pe.borabora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.borabora.entity.PaymentGateway;
import pe.borabora.service.PaymentGatewayService;

@RestController
@RequestMapping("/paymentgateway")
public class PaymentGatewayController {
    @Autowired
    private PaymentGatewayService paymentGatewayService;

    @PostMapping("/savepayment")
    public ResponseEntity<PaymentGateway> savePaymentGateway(@RequestBody PaymentGateway paymentGateway, @RequestParam Integer statusId) {
        try {
            PaymentGateway savedPaymentGateway = paymentGatewayService.savePaymentGateway(paymentGateway, statusId);
            return new ResponseEntity<>(savedPaymentGateway, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
