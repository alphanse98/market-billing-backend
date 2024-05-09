package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.repository.UsersRepository;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
}
