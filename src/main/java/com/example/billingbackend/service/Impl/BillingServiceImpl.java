package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.BillingTable;
import com.example.billingbackend.repository.BillingRepository;
import com.example.billingbackend.service.BillingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class BillingServiceImpl implements BillingService {

    @Autowired
    public BillingRepository billingRepository;
    @Override
    public BillingTable createBilling(BillingTable billingTable) {
        BillingTable billingTable1=billingRepository.save(billingTable);
        return billingTable1;
    }

    @Override
    public List<BillingTable> getAllBillings() {

        return billingRepository.findAll();
    }

    @Override
    public BillingTable updateBilling(BillingTable billingTable) {
        BillingTable billing=billingRepository.save(billingTable);
        return billing;
    }


}
