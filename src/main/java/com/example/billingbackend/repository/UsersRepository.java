package com.example.billingbackend.repository;

import com.example.billingbackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {

//    static List<Object> findfindByUserName(String username) {
//    }

     Optional <UserEntity> findByUsername(String username);
}
