package pe.borabora.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.borabora.entity.UserEntity;

import java.util.Optional;


public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByUsername(String username);
    boolean existsByIdentityDoc(Integer identityDoc);
    boolean existsByUsername(String username);
}
