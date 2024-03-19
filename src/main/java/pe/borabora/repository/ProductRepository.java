package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.category.id_category = :categoryId")
    List<Product> findByCategoryId(Integer categoryId);

    @Query("SELECT p, COUNT(pp) AS totalSold FROM Product p JOIN p.purchases pp GROUP BY p ORDER BY totalSold DESC")
    List<Object[]> findTopSellingProducts();
}
