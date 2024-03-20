package pe.borabora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.borabora.entity.PaymentGateway;
import pe.borabora.repository.PaymentGatewayRepository;
import pe.borabora.service.PaymentGatewayService;

@Service
public class PaymentGatewayServiceImpl implements PaymentGatewayService {
    @Autowired
    private PaymentGatewayRepository paymentGatewayRepository;
    @Override
    public PaymentGateway getPaymentById(Integer paymentId) {
        return paymentGatewayRepository.findById(paymentId).orElse(null);
    }
}
