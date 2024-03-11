package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
}
