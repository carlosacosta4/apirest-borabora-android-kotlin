package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
