package com.example.billingbackend.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginEntity {
    @NotEmpty
    @Column(nullable = false)
    private String username;
    @NotEmpty
    @Column(nullable = false)
    private String password;
}
