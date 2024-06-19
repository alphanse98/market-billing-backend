package com.example.billingbackend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    public Long id;

    @Column(nullable = false)
    public Long customerID;

    @NotEmpty
    @Column(nullable = false)
    public String businessID;

    @NotEmpty
    @Column(nullable = false,unique = true)
    public String billNumber;

    @NotEmpty
    @Size(max = 45, message = "item name should have atmost 45 characters")
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
