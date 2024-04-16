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

    @GetMapping("/all/{identityDoc}")
    public ResponseEntity<List<PurchasetResponse>> getAllPurchases(@PathVariable Integer identityDoc){
        List<PurchasetResponse> purchaseDTOS = purchaseService.getAllPurchases(identityDoc);
        return new ResponseEntity<>(purchaseDTOS, HttpStatus.OK);
    }


}
