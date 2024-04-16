package pe.borabora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.Purchase;
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
	
	@Query("SELECT p FROM Purchase p WHERE p.user.identityDoc = :identityDoc")
	List<Purchase> findAllByUserIdentityDoc(@Param("identityDoc") Integer identityDoc);
}
