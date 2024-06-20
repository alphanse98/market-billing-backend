package com.example.billingbackend.service;

import com.example.billingbackend.entity.BillingItemsEntity;

import java.util.List;

public interface BillingItemService  {

    List<BillingItemsEntity> createbillingitems(List<BillingItemsEntity> billingItems);

    List<BillingItemsEntity> getAllBillingItems();

    BillingItemsEntity updateBillingItems(BillingItemsEntity billingItems);
}
