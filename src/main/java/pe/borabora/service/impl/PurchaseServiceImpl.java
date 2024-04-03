package pe.borabora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.borabora.entity.*;
import pe.borabora.repository.PurchaseRepository;
import pe.borabora.service.PaymentGatewayService;
import pe.borabora.service.ProductService;
import pe.borabora.service.PurchaseService;
import pe.borabora.service.TypeOrderService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserDetailServiceImpl userService;

    @Autowired
    private PaymentGatewayService paymentGatewayService;

    @Autowired
    private TypeOrderService typeOrderService;

    @Autowired
    private ProductService productService;

	@Override
	public Purchase savePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		return null;
	}


    /*
    @Override
    public Purchase savePurchase(Purchase purchase) {
        // Verificar y asignar el ID del usuario
        if (purchase.getUser() != null && purchase.getUser().getIdentity_doc() != null) {
            Integer userId = purchase.getUser().getIdentity_doc();
            UserEntity user = userService.getUserById(userId);
            if (user != null) {
                purchase.getUser().setIdentity_doc(userId); // Asignar solo el ID del usuario
            }
        }

        // Verificar y asignar el método de pago
        if (purchase.getPayment() != null && purchase.getPayment().getPayment_id() != null) {
            PaymentGateway paymentGateway = paymentGatewayService.getPaymentById(purchase.getPayment().getPayment_id());
            if (paymentGateway != null) {
                purchase.setPayment(paymentGateway);
            }
        }

        // Verificar y asignar el tipo de orden
        if (purchase.getOrder() != null && purchase.getOrder().getType_order_id() != null) {
            TypeOrder typeOrder = typeOrderService.getTypeOrderById(purchase.getOrder().getType_order_id());
            if (typeOrder != null) {
                purchase.setOrder(typeOrder);
            }
        }

        // Verificar y asignar los productos
        if (purchase.getProducts() != null && !purchase.getProducts().isEmpty()) {
            for (Product product : purchase.getProducts()) {
                Product existingProduct = productService.getProductById(product.getId_product());
                if (existingProduct != null) {
                    purchase.getProducts().add(existingProduct);
                }
            }
        }

        return purchaseRepository.save(purchase);
    }*/
}
