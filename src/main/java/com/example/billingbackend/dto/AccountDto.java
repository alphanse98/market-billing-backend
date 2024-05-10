package com.example.billingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String name;
    private String businessName ;
    private Long mobile;
    private Long secMobile;
    private String email;
    private String address;
    private boolean isActive;
    private String username;
    private String password;

}
