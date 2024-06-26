package com.example.billingbackend.controller;

import com.example.billingbackend.entity.CustomerEntity;
import com.example.billingbackend.service.CustomerService;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("api/customer/")
public class CustomerController {

    private CustomerService customerService;
    private UserService userService;
    @PostMapping("create")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerEntity customer){
        System.out.println(">>> customer >> "+ customer);
     customerService.createCustomer(customer);
        return new ResponseEntity<>("Successfully Created", HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers(Principal principal){
        String businessId =userService.findByUserName(principal.getName()).getBusinessID();
//        System.out.println("<<<<<<<<<<<<<<<< username = " + businessID);
        List<CustomerEntity> customerList = customerService.getAllCustomers(businessId);
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }


    @GetMapping("get/{id}")
    public ResponseEntity<CustomerEntity> getCustomer(@PathVariable("id") Long id){
        CustomerEntity customer=customerService.findByCustomerId(id);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<CustomerEntity> customerUpdate(@RequestBody CustomerEntity customer){
        CustomerEntity updated  = customerService.updateCustomerByBusinessID(customer);
        return new ResponseEntity<>(updated ,HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerEntity> deleteCustomer(@RequestBody CustomerEntity customer1, @PathVariable Long id){
        CustomerEntity customs=customerService.deleteCustomers(customer1,id);
        return new ResponseEntity<>(customs,HttpStatus.OK);

    }
}
