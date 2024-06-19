package com.example.billingbackend.repository;

import com.example.billingbackend.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {

//    static List<Object> findfindByUserName(String username) {
//    }

     Optional <UserEntity> findByUsername(String username);

     List<UserEntity> findByBusinessID(String businessID);

     @Modifying
     @Transactional
     @Query("UPDATE UserEntity i SET i.role= :role, i.username = :username, i.password= :password WHERE i.id= :id AND i.businessID= :businessID")
     int updateUserByBusinessIDandId(@Param("role") String role, @Param("username") String username, @Param("password") String password, @Param("id") Long id, @Param("businessID") String businessID);


}
