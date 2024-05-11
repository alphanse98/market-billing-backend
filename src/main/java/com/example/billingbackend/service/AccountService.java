package com.example.billingbackend.service;

import com.example.billingbackend.entity.AccountEntity;

public interface AccountService {

    void accountRegister (AccountEntity request) ;

    AccountEntity findByMobile(Long request);
}
