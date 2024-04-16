package pe.borabora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.borabora.entity.Purchase;
import pe.borabora.entity.PurchaseProduct;
@Repository
public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, Integer> {
	
}
