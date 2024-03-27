package com.example.billingbackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class Test {
    @CrossOrigin(origins = "*")
    @GetMapping("api/test")
    public String testApi (){
        return "api is working nice " ;
    }
}
