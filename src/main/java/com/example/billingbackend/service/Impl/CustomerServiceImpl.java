package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.CustomerEntity;
import com.example.billingbackend.repository.CustomerRepository;
import com.example.billingbackend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository CustomerRepository;
    @Override
    public void createCustomer(CustomerEntity request) {
        CustomerRepository.save(request);
    }
}
