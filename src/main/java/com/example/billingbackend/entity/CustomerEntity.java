package com.example.billingbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String businessId;

    @Column(nullable = false)
    private String customersName;

    @NotEmpty
//    @Digits(integer = 10, fraction = 0, message = "number should have at least 10 digits")
    @Column(nullable = false)
    private Long mobile;

    @Column(nullable = false)
    private String address;

    @Column(nullable = true)
    private Long secMobile;

    @NotEmpty
    @Email
    @Column(nullable = true)
    private String email;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String createDate;
}
