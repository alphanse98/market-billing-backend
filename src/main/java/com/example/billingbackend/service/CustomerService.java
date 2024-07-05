package com.example.billingbackend.service;

import com.example.billingbackend.entity.CustomerEntity;

import java.util.List;


public interface CustomerService {

    void createCustomer(CustomerEntity request);
    List<CustomerEntity> getAllCustomers(String businessID);
    CustomerEntity findByCustomerId(Long id);
    CustomerEntity updateCustomer(CustomerEntity customer);
    void deleteCustomers(CustomerEntity request);

    CustomerEntity updateCustomerByBusinessID(CustomerEntity customerEntity);

}
