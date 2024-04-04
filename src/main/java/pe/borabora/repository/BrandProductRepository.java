package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.BrandProduct;
@Repository
public interface BrandProductRepository extends JpaRepository<BrandProduct, Integer> {
}
