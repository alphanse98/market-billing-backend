package com.example.billingbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customerBalance")
public class CustomerBalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String businessID;

    @Column(nullable = false)
    private Long customerID;

    @NotEmpty
    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private Long mobile;

    @Column(nullable = false)
    private Long balanceAmount;

    @JsonProperty("isActive")
    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String description;

    @NotEmpty
    @Column(nullable = false)
    private String createDate;

}
