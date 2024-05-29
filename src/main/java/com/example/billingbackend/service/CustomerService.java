package com.example.billingbackend.service;

import com.example.billingbackend.entity.CustomerEntity;

import java.util.List;


public interface CustomerService {

    void createCustomer(CustomerEntity request);
    List<CustomerEntity> getAllCustomers();
    CustomerEntity findByCustomerId(Long id);
    CustomerEntity updateCustomer(CustomerEntity customer);
    CustomerEntity deleteCustomers(CustomerEntity customer1, Long id);

}
