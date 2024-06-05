package com.example.billingbackend.service;

import com.example.billingbackend.entity.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    void userRegister (UserEntity request);

    UserEntity createUser(UserEntity userEntity);
    List<UserEntity> getAllUsers();

    UserEntity updateUser(UserEntity userEntity);

    void deleteUsers(Long id);

    UserEntity findByUserName(String UserName);

}
