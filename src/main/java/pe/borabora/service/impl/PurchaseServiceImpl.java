package pe.borabora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.borabora.dto.PurchaseDTO;
import pe.borabora.entity.*;
import pe.borabora.repository.PaymentGatewayRepository;
import pe.borabora.repository.PurchaseRepository;
import pe.borabora.repository.TypeOrderRepository;
import pe.borabora.repository.UserRepository;
import pe.borabora.service.PaymentGatewayService;
import pe.borabora.service.ProductService;
import pe.borabora.service.PurchaseService;
import pe.borabora.service.TypeOrderService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentGatewayRepository paymentGatewayRepository;

    @Autowired
    private TypeOrderRepository typeOrderRepository;

    @Override
    public void createPurchase(PurchaseDTO request) {
        Purchase purchase = new Purchase();
        purchase.setTotal(request.getTotal());
        purchase.setIgv(request.getIgv());
        purchase.setSubtotal(request.getSubtotal());
        purchase.setPurchaseDate(request.getPurchaseDate());

        // Obtener y establecer UserEntity
        UserEntity user = userRepository.findByIdentityDoc(request.getIdentityDoc())
                .orElseThrow(() -> new RuntimeException("User not found"));
        purchase.setUser(user);

        // Obtener y establecer PaymentGateway
        PaymentGateway payment = paymentGatewayRepository.findById(request.getPaymentId())
                .orElseThrow(() -> new RuntimeException("PaymentGateway not found"));
        purchase.setPayment(payment);

        // Obtener y establecer TypeOrder
        TypeOrder order = typeOrderRepository.findById(request.getTypeOrderId())
                .orElseThrow(() -> new RuntimeException("TypeOrder not found"));
        purchase.setOrder(order);

        // Guardar Purchase en la base de datos
        purchaseRepository.save(purchase);

        // Para los productos, puedes manejarlos de manera similar
        for (Integer productId : request.getProductIds()) {
            // Aquí puedes hacer lo necesario para manejar los productos
        }
    }
}
