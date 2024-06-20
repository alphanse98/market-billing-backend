package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.BillingItemsEntity;
import com.example.billingbackend.repository.BillingItemRepository;
import com.example.billingbackend.service.BillingItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class BillingItemServiceImpl implements BillingItemService {

    @Autowired
    public BillingItemRepository billingItemRepository;
    @Override
    public List<BillingItemsEntity> createbillingitems(List<BillingItemsEntity> billingItems) {
        List<BillingItemsEntity> billingItems1=billingItemRepository.saveAll(billingItems);
        return billingItems1;
    }

    @Override
    public List<BillingItemsEntity> getAllBillingItems() {
        return billingItemRepository.findAll();
    }

    @Override
    public BillingItemsEntity updateBillingItems(BillingItemsEntity billingItems) {
        BillingItemsEntity updateBillingItems=billingItemRepository.save(billingItems);
        return updateBillingItems;
    }
}
