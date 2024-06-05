package com.example.billingbackend.repository;

import com.example.billingbackend.entity.BillingItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingItemRepository extends JpaRepository<BillingItemsEntity,String> {
}
