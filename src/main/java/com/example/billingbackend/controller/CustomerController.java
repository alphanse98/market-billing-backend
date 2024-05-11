package com.example.billingbackend.controller;

import com.example.billingbackend.entity.CustomerEntity;
import com.example.billingbackend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/customer/")
public class CustomerController {

    private CustomerService customerService;
    @PostMapping("create")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerEntity customer){
         customerService.createCustomer(customer);
        return new ResponseEntity<>("Successfully Created", HttpStatus.CREATED);
    }
}
