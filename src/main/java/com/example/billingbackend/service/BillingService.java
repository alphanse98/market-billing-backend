package com.example.billingbackend.service;

import com.example.billingbackend.entity.BillingEntity;

import java.util.List;

public interface BillingService {

    BillingEntity createBilling(BillingEntity billingTable);
    List<BillingEntity> getAllBillings();

    BillingEntity updateBilling(BillingEntity billingTable);
}
