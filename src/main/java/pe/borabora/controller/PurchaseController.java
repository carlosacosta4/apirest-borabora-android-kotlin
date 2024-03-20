package pe.borabora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.borabora.entity.Purchase;
import pe.borabora.service.PurchaseService;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/purchase")
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
        Purchase savedPurchase = purchaseService.savePurchase(purchase);
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }
}
