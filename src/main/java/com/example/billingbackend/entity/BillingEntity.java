package com.example.billingbackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "billingtable")
public class BillingEntity {
    @Id
    @Column(nullable = false)
    public String customerID;

    @Column(nullable = false)
    public String businessID;

    @Column(nullable = false)
    public String billNumber;

    @Column(nullable = false)
    public String customerName;

    @Column(nullable = false)
    public String date;

    @Column(nullable = false)
    public boolean isActive;

    @Column(nullable = false)
    public Long totalAmount;

    @Column(nullable = false)
    public Long paidAmount;

    @Column(nullable = false)
    public Long balanceAmount;

}
