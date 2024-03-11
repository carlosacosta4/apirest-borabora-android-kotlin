package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
