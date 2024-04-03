package pe.borabora.service;

import pe.borabora.dto.PurchaseDTO;
import pe.borabora.entity.Purchase;

public interface PurchaseService {
    void createPurchase(PurchaseDTO request);
}
