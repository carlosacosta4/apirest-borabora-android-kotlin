package pe.borabora.service;

import pe.borabora.entity.PaymentGateway;

public interface PaymentGatewayService {
    PaymentGateway getPaymentById(Integer paymentId);
}
