package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.PaymentGateway;

@Repository
public interface PaymentGatewayRepository extends JpaRepository<PaymentGateway, Integer> {
}
