package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.PurchaseProduct;
@Repository
public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, Integer> {
}
