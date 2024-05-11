package com.example.billingbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column( unique = true)
    private String businessID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false , unique = true)
    private Long mobile;

    @Column(nullable = true , unique = true)
    private Long secMobile;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private boolean isActive;

}
