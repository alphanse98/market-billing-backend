package com.example.billingbackend.controller;

import com.example.billingbackend.entity.CustomerEntity;
import com.example.billingbackend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("get")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers(){
        List<CustomerEntity> customerEntities=customerService.getAllCustomers();
        return new ResponseEntity<>(customerEntities,HttpStatus.OK);
    }


    @GetMapping("get/{id}")
    public ResponseEntity<CustomerEntity> getCustomer(@PathVariable("id") Long id){
        CustomerEntity customer=customerService.findByCustomerId(id);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<CustomerEntity> customerUpdate(@RequestBody CustomerEntity customer){
        CustomerEntity customerupdated=customerService.updateCustomer(customer);
        return new ResponseEntity<>(customerupdated,HttpStatus.OK);
    }


    @DeleteMapping("delete")
    public ResponseEntity<String> deleteCustomer(){
        customerService.deleteCustomers();
        return new ResponseEntity<>("deleted successfully",HttpStatus.NO_CONTENT);

    }
// test



}
