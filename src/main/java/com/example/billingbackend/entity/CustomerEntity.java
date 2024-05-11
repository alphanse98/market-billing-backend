package com.example.billingbackend.entity;

import jakarta.persistence.*;
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

    @Column(nullable = false)
    private Long mobile;

    @Column(nullable = false)
    private String address;

    @Column(nullable = true)
    private Long secMobile;

    @Column(nullable = true)
    private String email;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String createDate;
}
