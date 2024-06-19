package com.example.billingbackend.service;

import com.example.billingbackend.entity.BillingEntity;
import com.example.billingbackend.entity.BillingItemsEntity;

import java.util.List;

public interface BillingService {

    BillingEntity createBilling(BillingEntity billingTable);
    List<BillingEntity> getAllBillings(String businessID);

    BillingEntity updateBilling(BillingEntity billingTable);

    BillingEntity updateBillingByBusinessID(BillingEntity billingEntity);
}
