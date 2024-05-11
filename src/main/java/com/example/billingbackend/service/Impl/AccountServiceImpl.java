package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.AccountEntity;
import com.example.billingbackend.repository.AccountRepository;
import com.example.billingbackend.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    AccountRepository AccountRepository;
    @Override
    public void accountRegister(AccountEntity request) {
        AccountRepository.save(request);
    }

    @Override
    public AccountEntity findByMobile(Long request) {
        return AccountRepository.findByMobile(request);
    }
}
