package pe.borabora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.borabora.dto.PurchaseDTO;
import pe.borabora.dto.response.PurchasetResponse;
import pe.borabora.entity.Purchase;
import pe.borabora.service.PurchaseService;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchases")
    public ResponseEntity<String> createPurchase(@RequestBody PurchaseDTO request) {
        try {
            purchaseService.createPurchase(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Purchase created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating purchase: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PurchasetResponse>> getAllPurchases(){
        List<PurchasetResponse> purchaseDTOS = purchaseService.getAllPurchases();
        return new ResponseEntity<>(purchaseDTOS, HttpStatus.OK);
    }



}
