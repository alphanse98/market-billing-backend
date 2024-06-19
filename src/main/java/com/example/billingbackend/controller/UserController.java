package com.example.billingbackend.controller;

import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController  {

    public UserService userService;

    @PostMapping("create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        UserEntity userEntity1=userService.createUser(userEntity);
        return new ResponseEntity<>(userEntity1, HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<List<UserEntity>> getAllUsers(Principal principal){
         String businessID=userService.findByUserName(principal.getName()).getBusinessID();
         List<UserEntity> userEntities=userService.getAllUsers(businessID);
         return new ResponseEntity<>(userEntities,HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity){
        UserEntity userupdated=userService.updateUserByBusinessID(userEntity);
        return new ResponseEntity<>(userupdated,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUsers(id);
        return new ResponseEntity<>("user deleted successfully", HttpStatus.NO_CONTENT);
    }

}




