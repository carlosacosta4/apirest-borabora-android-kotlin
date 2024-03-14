package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.PickUp;
@Repository
public interface PickUpRepository extends JpaRepository<PickUp, Integer> {
}
