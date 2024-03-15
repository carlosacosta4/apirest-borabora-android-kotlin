package pe.borabora.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.borabora.entity.CardType;
import pe.borabora.entity.PaymentGateway;
import pe.borabora.entity.Status;
import pe.borabora.repository.CardTypeRepository;
import pe.borabora.repository.PaymentGatewayRepository;
import pe.borabora.repository.StatusRepository;

import java.util.Optional;

@Service
public class PaymentGatewayService {
    @Autowired
    private PaymentGatewayRepository paymentGatewayRepository;

    @Autowired
    private CardTypeRepository cardTypeRepository;

    @Autowired
    private StatusRepository statusRepository;

    public PaymentGateway savePaymentGateway(PaymentGateway paymentGateway, Integer statusId) {
        // Verificar si el estado ya está persistido
        Optional<Status> optionalStatus = statusRepository.findById(statusId);
        if (optionalStatus.isPresent()) {
            Status status = optionalStatus.get();
            paymentGateway.setStatus(status);
            return paymentGatewayRepository.save(paymentGateway);
        } else {
            // Manejar el caso en el que el estado no exista
            throw new IllegalArgumentException("El estado con ID " + statusId + " no fue encontrado.");
        }
    }
}
