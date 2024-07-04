package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.CustomerBalanceEntity;
import com.example.billingbackend.repository.CustomerBalanceRepository;
import com.example.billingbackend.service.CustomerBalanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerBalanceServiceImpl implements CustomerBalanceService {

    @Autowired
    private CustomerBalanceRepository customerBalanceRepository;
    @Override
    public CustomerBalanceEntity addCustomerBalanceService(CustomerBalanceEntity customerBalanceEntity) {
        return customerBalanceRepository.save(customerBalanceEntity);
    }

    @Override
    public List<CustomerBalanceEntity> getAllCustomerBalance(String businessID) {
        return customerBalanceRepository.findByBusinessID(businessID);
    }

    @Override
    public CustomerBalanceEntity updateCustomerBalanceByBusinessID(CustomerBalanceEntity customerBalanceEntity) {
        customerBalanceRepository.updateCustomerBalanceByBusinessIDAndId(
                customerBalanceEntity.getBalanceAmount(),
                customerBalanceEntity.getId(),
                customerBalanceEntity.getBusinessID()
        );
        return customerBalanceEntity;
    }

    @Override
    public void deleteCustomerBalance(CustomerBalanceEntity customerBalanceEntity) {
        customerBalanceRepository.deleteCustomerBalance(false, customerBalanceEntity.getId(), customerBalanceEntity.getBusinessID());
    }
}
