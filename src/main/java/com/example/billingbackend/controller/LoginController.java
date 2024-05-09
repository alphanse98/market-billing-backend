package com.example.billingbackend.controller;

import com.example.billingbackend.entity.LoginEtity;
import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.security.JwtUtil;
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

    @GetMapping("api/login")
    public ResponseEntity<String> jwtTest (@RequestBody LoginEtity requestData){

//        System.out.println( "req >> "+ requestData);

        String userName = requestData.getUsername();
        String password = requestData.getPassword();

//        System.out.println("requestData >> " + requestData);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password);

        authenticationManager.authenticate(token);

        String jetToken = JwtUtil.generateJwt(userName);
        return ResponseEntity.ok(jetToken) ;
    }

    @PostMapping("api/register")
    public  ResponseEntity<String>  account (@RequestBody UserEntity requestData){

        UserService.userRegister(requestData);
        return ResponseEntity.ok("Register successfully");
    }


//    @PostMapping("api/register")
//    public ResponseEntity<String>  register(@RequestBody UserEntity request){
//        UserService.userRegister(request);
//        return ResponseEntity.ok("Register successfully");
//    }
}
