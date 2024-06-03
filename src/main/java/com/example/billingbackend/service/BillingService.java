package com.example.billingbackend.service;

import com.example.billingbackend.entity.BillingTable;

import java.util.List;

public interface BillingService {

    BillingTable createBilling(BillingTable billingTable);
    List<BillingTable> getAllBillings();

    BillingTable updateBilling(BillingTable billingTable);
}
