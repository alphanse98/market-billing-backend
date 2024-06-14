package com.example.billingbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    @Column( unique = true)
    private String businessID;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private String businessName;

    @NotEmpty
    @Column(nullable = false , unique = true)
    private Long mobile;

    @Column(nullable = true , unique = true)
    private Long secMobile;

    @NotEmpty
    @Email
    @Column(nullable = true, unique = true)
    private String email;

    @NotEmpty
    @Column(nullable = false)
    private String address;

    @NotEmpty
    @Column(nullable = false)
    private boolean isActive;

}
