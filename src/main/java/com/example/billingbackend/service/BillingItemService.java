package com.example.billingbackend.service;

import com.example.billingbackend.entity.BillingItemsEntity;

import java.util.List;

public interface BillingItemService  {

    BillingItemsEntity createbillingitems(BillingItemsEntity billingItems);

    List<BillingItemsEntity> getAllBillingItems();

    BillingItemsEntity updateBillingItems(BillingItemsEntity billingItems);
}
