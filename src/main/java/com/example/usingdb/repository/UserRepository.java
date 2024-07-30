package com.example.usingdb.repository;

import com.example.usingdb.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    // Puede arrojar un error aqui :3
    Optional<UserEntity> findByUserName(String username);

}
