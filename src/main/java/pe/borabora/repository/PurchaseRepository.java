package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.Purchase;
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
