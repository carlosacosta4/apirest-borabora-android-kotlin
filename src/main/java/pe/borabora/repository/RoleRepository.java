package pe.borabora.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.borabora.entity.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}