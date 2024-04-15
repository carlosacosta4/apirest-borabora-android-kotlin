package pe.borabora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.borabora.dto.PurchaseDTO;
import pe.borabora.dto.response.PurchasetResponse;
import pe.borabora.entity.*;
import pe.borabora.repository.*;
import pe.borabora.service.PurchaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private PickUpRepository pickUpRepository;

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

        // Verificar si es una entrega (Delivery) o una recogida (PickUp) según el ID del pedido
        TypeOrder order;
        if (request.getOrderId() != null) {
            // Buscar el pedido correspondiente en la base de datos
            Optional<Delivery> deliveryOptional = deliveryRepository.findById(request.getOrderId());
            if (deliveryOptional.isPresent()) {
                order = deliveryOptional.get();
            } else {
                Optional<PickUp> pickUpOptional = pickUpRepository.findById(request.getOrderId());
                if (pickUpOptional.isPresent()) {
                    order = pickUpOptional.get();
                } else {
                    throw new RuntimeException("Order not found");
                }
            }
        } else {
            throw new IllegalArgumentException("Order ID is required");
        }

        purchase.setOrder(order);


        // Guardar Purchase en la base de datos
        purchaseRepository.save(purchase);

        // Para los productos, puedes manejarlos de manera similar
        for (Integer productId : request.getProductIds()) {
            // Aquí puedes hacer lo necesario para manejar los productos
        }
    }

    @Override
    public List<PurchasetResponse> getAllPurchases() {
        List<Purchase> purchaseList = purchaseRepository.findAll();

        return purchaseList.stream().map(purchase -> {
            PurchasetResponse purchaseDTO = new PurchasetResponse();
            purchaseDTO.setTotal(purchase.getTotal());
            purchaseDTO.setIgv(purchase.getIgv());
            purchaseDTO.setSubtotal(purchase.getSubtotal());
            purchaseDTO.setPurchaseDate(purchase.getPurchaseDate());
            purchaseDTO.setPaymentId(purchase.getPayment().getPayment_id());
            purchaseDTO.setIdentityDoc(purchase.getUser().getIdentityDoc());
            purchaseDTO.setOrderType(purchase.getOrder().getType());
            purchaseDTO.setProductIds(purchase.getProducts().stream().map(Product::getId_product).collect(Collectors.toList()));
            return purchaseDTO;
        }).collect(Collectors.toList());
    }

}
