package pe.borabora.service;

import pe.borabora.dto.PurchaseDTO;
import pe.borabora.dto.response.PurchasetResponse;

import java.util.List;

public interface PurchaseService {
    void createPurchase(PurchaseDTO request);
    List<PurchasetResponse> getAllPurchases(Integer identityDoc);
}
