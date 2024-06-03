package com.example.billingbackend.repository;

import com.example.billingbackend.entity.BillingTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<BillingTable,String> {
}
