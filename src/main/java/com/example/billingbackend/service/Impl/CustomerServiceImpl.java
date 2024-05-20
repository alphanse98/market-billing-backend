package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.CustomerEntity;
import com.example.billingbackend.repository.CustomerRepository;
import com.example.billingbackend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository CustomerRepository;
    @Override
    public void createCustomer(CustomerEntity request) {
        CustomerRepository.save(request);
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return CustomerRepository.findAll();
    }

    @Override
    public CustomerEntity findByCustomerId(Long id) {
        return CustomerRepository.findById(id).get();
    }

    @Override
    public CustomerEntity updateCustomer(CustomerEntity customer) {


        CustomerEntity customerResponse;
        customerResponse = CustomerRepository.save(customer);
        return customerResponse;

    }

    @Override
    public void deleteCustomers() {

        CustomerRepository.deleteAll();
    }


}
