package com.example.billingbackend.controller;

import com.example.billingbackend.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class JetTest {

    public JwtUtil JwtUtil;
    @GetMapping("jwt")
    public  String jwtTest (){

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("admin", "admin");
//        System.out.println( "UsernamePasswordAuthenticationToken >> "+ token);

        String jetToken = JwtUtil.generateJwt("admin");
        return  jetToken;
    }
}
