package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.CustomerEntity;
import com.example.billingbackend.entity.Item;
import com.example.billingbackend.repository.CustomerRepository;
import com.example.billingbackend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public CustomerEntity deleteCustomers(CustomerEntity customer1, Long id) {

        CustomerEntity customerfind = CustomerRepository.findById(id).get();

        if(customer1.isActive()==true){
            customer1.setActive(false);
        }

        CustomerRepository.save(customerfind);
        return customerfind;
    }


}
