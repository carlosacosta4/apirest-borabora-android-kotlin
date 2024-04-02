package pe.borabora.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.borabora.entity.UserEntity;

import java.util.Optional;


public interface UserRepository extends CrudRepository<UserEntity, Long> {


    boolean existsByIdentityDoc(Integer identityDoc);
    boolean existsByUsername(String username);
    
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByIdentityDoc(Integer identityDoc);
}
