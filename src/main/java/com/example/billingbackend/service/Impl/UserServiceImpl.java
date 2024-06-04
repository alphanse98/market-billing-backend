package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.repository.UsersRepository;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    public UsersRepository UsersRepository;
    public PasswordEncoder PasswordEncoder;

    @Override
    public void userRegister(UserEntity request) {
        request.setPassword(PasswordEncoder.encode(request.getPassword())); // encode pass
        UsersRepository.save(request);
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        UserEntity userEntity1=UsersRepository.save(userEntity);
        return userEntity1;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return UsersRepository.findAll();
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        UserEntity user=UsersRepository.save(userEntity);
        return user;
    }

    @Override
    public void deleteUsers(Long id) {
        UserEntity users=UsersRepository.findById(id).get();
        UsersRepository.delete(users);
    }

    @Override
    public UserEntity findByUserName(String UserName) {
        return UsersRepository.findByUsername(UserName).get();

    }


}
