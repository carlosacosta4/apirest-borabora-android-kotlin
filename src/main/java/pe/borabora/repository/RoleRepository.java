package pe.borabora.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.borabora.entity.RoleEntity;
import pe.borabora.model.RoleEnum;

import java.util.List;
import java.util.Optional;


public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

    List<RoleEntity> findRoleEntitiesByRoleEnumIn(List<RoleEnum> roleEnums);

    Optional<RoleEntity> findByRoleEnum(RoleEnum roleEnum);
}
