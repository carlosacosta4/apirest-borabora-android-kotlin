package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.Headquarter;

@Repository
public interface HeadquarterRepository extends JpaRepository<Headquarter, Integer> {
}

