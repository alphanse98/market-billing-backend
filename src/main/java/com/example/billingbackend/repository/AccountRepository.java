package com.example.billingbackend.repository;

import com.example.billingbackend.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity , String> {
}
