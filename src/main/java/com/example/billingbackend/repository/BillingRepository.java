package com.example.billingbackend.repository;

import com.example.billingbackend.entity.BillingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<BillingEntity,String> {
}
