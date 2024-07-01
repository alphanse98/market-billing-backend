package com.example.billingbackend.service;

import com.example.billingbackend.entity.CustomerBalanceEntity;

import java.util.List;

public interface CustomerBalanceService {

    CustomerBalanceEntity addCustomerBalanceService(CustomerBalanceEntity customerBalanceEntity);

    List<CustomerBalanceEntity> getAllCustomerBalance(String businessID);

    CustomerBalanceEntity updateCustomerBalanceByBusinessID(CustomerBalanceEntity customerBalanceEntity);

    void deleteCustomerBalance(CustomerBalanceEntity customerBalanceEntity);
}
