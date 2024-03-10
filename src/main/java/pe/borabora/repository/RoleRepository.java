package pe.borabora.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.borabora.entity.RoleEntity;


@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
}