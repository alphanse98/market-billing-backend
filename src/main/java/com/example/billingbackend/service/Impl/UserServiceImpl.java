package com.example.billingbackend.service.Impl;

import com.example.billingbackend.dto.UsernameCheckDto;
import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.repository.UsersRepository;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.ClassUtils.isPresent;

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
        userEntity.setPassword(PasswordEncoder.encode(userEntity.getPassword())); // encode pass
        return UsersRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers(String businessID) {
        return UsersRepository.findByBusinessID(businessID);
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
//        if(UsersRepository.findByUsername(UserName).get().equals(UsernameCheckDto usernameCheckDto)){
//
//        }
        return UsersRepository.findByUsername(UserName).get();
    }

    @Override
    public Boolean findByName(String username) {
        if(UsersRepository.findByUsername(username).isPresent()) {
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public UserEntity updateUserByBusinessID(UserEntity userEntity) {

        userEntity.setPassword(PasswordEncoder.encode(userEntity.getPassword())); // encode pass

        UsersRepository.updateUserByBusinessIDandId(
                userEntity.getRole(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getId(),
                userEntity.getBusinessID()
        );
        return userEntity;
    }


}
