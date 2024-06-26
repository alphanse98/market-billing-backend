package com.example.billingbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "billSettings")
public class BillSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String businessID;

    @NotEmpty
    @Column(nullable = false)
    private String brandName;

    @NotEmpty
    private String address;

    @Column(nullable = false)
    private Long mobile;

    private Long secMobile;

    @NotEmpty
    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean customerID;

    @Column(nullable = false)
    private boolean customerName;

}
