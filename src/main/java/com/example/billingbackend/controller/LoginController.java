package com.example.billingbackend.controller;

import com.example.billingbackend.dto.AccountDto;
import com.example.billingbackend.entity.AccountEntity;
import com.example.billingbackend.entity.LoginEntity;
import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.security.JwtUtil;
import com.example.billingbackend.service.AccountService;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    public JwtUtil JwtUtil;
    private AuthenticationManager authenticationManager;
    public  UserService UserService;
    AccountService AccountService;

    @GetMapping("api/login")
    public ResponseEntity<String> jwtTest (@RequestBody LoginEntity requestData){

//        System.out.println( "req >> "+ requestData);

        String userName = requestData.getUsername();
        String password = requestData.getPassword();

//        System.out.println("requestData >> " + requestData);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password);

        authenticationManager.authenticate(token);

        String jetToken = JwtUtil.generateJwt(userName);
        return ResponseEntity.ok(jetToken);
    }

    @PostMapping("api/register")
    public  ResponseEntity<String>  account (@RequestBody AccountDto requestData){

        System.out.println(" <<<<<<<<<<<<<<< register >>>>>>" +  requestData);

        // Convert AccountDto to AccountEntity
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(requestData.getName());
        accountEntity.setBusinessName(requestData.getBusinessName());
        accountEntity.setMobile(requestData.getMobile());
        accountEntity.setSecMobile(requestData.getSecMobile());
        accountEntity.setEmail(requestData.getEmail());
        accountEntity.setAddress(requestData.getAddress());
        accountEntity.setActive(requestData.isActive());

        // Convert AccountDto to UserEntity
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(requestData.getUsername());
        userEntity.setPassword(requestData.getPassword());

        // Pass the entities to the respective service methods
        AccountService.accountRegister(accountEntity);
        UserService.userRegister(userEntity);

        return ResponseEntity.ok("Register successfully");
    }
}
