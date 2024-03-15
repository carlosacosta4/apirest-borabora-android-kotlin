package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{

}
