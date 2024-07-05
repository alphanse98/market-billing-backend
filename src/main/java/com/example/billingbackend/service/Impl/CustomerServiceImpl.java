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

    CustomerRepository customerRepository;
    @Override
    public void createCustomer(CustomerEntity request) {
        customerRepository.save(request);
    }

    @Override
    public List<CustomerEntity> getAllCustomers(String businessID) {

        return customerRepository.findByBusinessID(businessID);
    }

    @Override
    public CustomerEntity findByCustomerId(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public CustomerEntity updateCustomer(CustomerEntity customer) {
        CustomerEntity customerResponse;
        customerResponse = customerRepository.save(customer);
        return customerResponse;
    }

    @Override
    public void deleteCustomers(CustomerEntity request) {
//        public void deleteItems(Item item) {
//            itemRepository.deleteItem(false,item.getId(), item.getBusinessID());
//        }
        customerRepository.deleteCustomer(false, request.getId(), request.getBusinessID());

    }

    @Override
    public CustomerEntity updateCustomerByBusinessID(CustomerEntity customerEntity) {
        customerRepository.updateCustomerByBusinessIDAndId(
                customerEntity.getCustomersName(),
                customerEntity.getMobile(),
                customerEntity.getAddress(),
                customerEntity.getSecMobile(),
                customerEntity.getEmail(),
                customerEntity.isActive(),
                customerEntity.getCreateDate(),
                customerEntity.getId(),
                customerEntity.getBusinessID()

        );
        return customerEntity;
    }


}
