package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.BillingEntity;
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
    public BillingEntity createBilling(BillingEntity billingTable) {
        BillingEntity billingTable1=billingRepository.save(billingTable);
        return billingTable1;
    }

    @Override
    public List<BillingEntity> getAllBillings() {

        return billingRepository.findAll();
    }

    @Override
    public BillingEntity updateBilling(BillingEntity billingTable) {
        BillingEntity billing=billingRepository.save(billingTable);
        return billing;
    }


}
