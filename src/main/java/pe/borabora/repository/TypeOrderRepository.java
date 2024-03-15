package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.TypeOrder;

@Repository
public interface TypeOrderRepository extends JpaRepository<TypeOrder, Integer> {
}
