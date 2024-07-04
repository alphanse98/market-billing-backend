package com.example.billingbackend.controller;

import com.example.billingbackend.entity.CustomerBalanceEntity;
import com.example.billingbackend.service.CustomerBalanceService;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("api/customerbalance/")
public class CustomerBalanceController {

    @Autowired
    private CustomerBalanceService customerBalanceService;
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<CustomerBalanceEntity> addCustomerBalance(@RequestBody CustomerBalanceEntity customerBalanceEntity){
       CustomerBalanceEntity customerBalance = customerBalanceService.addCustomerBalanceService(customerBalanceEntity);
       return new ResponseEntity<>(customerBalance, HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<List<CustomerBalanceEntity>> getAllCustomerBalance(Principal principal){
       String businessID = userService.findByUserName(principal.getName()).getBusinessID();
       List<CustomerBalanceEntity> customerBalanceEntityList = customerBalanceService.getAllCustomerBalance(businessID);
       return new ResponseEntity<>(customerBalanceEntityList,HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<CustomerBalanceEntity> updateCustomerBalance(@RequestBody CustomerBalanceEntity customerBalanceEntity){
        CustomerBalanceEntity updatedCustomerBalance = customerBalanceService.updateCustomerBalanceByBusinessID(customerBalanceEntity);
        return new ResponseEntity<>(updatedCustomerBalance,HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteCustomerBalance(@RequestBody CustomerBalanceEntity customerBalanceEntity){
        customerBalanceService.deleteCustomerBalance(customerBalanceEntity);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }

}
