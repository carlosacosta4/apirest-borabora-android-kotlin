package pe.borabora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.borabora.entity.CardType;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType, Integer> {
}
