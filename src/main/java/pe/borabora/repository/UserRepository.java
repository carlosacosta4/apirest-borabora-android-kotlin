package pe.borabora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.borabora.entity.UserEntity;


public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsername(String username);

}

