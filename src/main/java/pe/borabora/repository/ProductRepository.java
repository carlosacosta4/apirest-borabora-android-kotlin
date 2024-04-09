package pe.borabora.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.category.id_category = :categoryId")
    List<Product> findByCategoryId(Integer categoryId);

    @Query("SELECT p, COUNT(pp) AS totalSold FROM Product p JOIN p.purchases pp WHERE p.deleted = false GROUP BY p ORDER BY totalSold DESC")
    List<Object[]> findTopSellingProducts(Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.deleted = false")
    List<Product> findAllByDeletedFalse();

    //encuentre producto por id, menos los que tienen deleted = true
    @Query("SELECT p FROM Product p WHERE p.id = :id AND p.deleted = false")
    Optional<Product> findByIdAndDeletedFalse(@Param("id") Integer id);
}
