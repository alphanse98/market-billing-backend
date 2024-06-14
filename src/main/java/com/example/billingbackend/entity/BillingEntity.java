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
    public String customerID;

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

    @NotEmpty
    @Column(nullable = false)
    public String date;

    @NotEmpty
    @Column(nullable = false)
    public boolean isActive;

    @NotEmpty
    @Column(nullable = false)
    public Long totalAmount;

    @NotEmpty
    @Column(nullable = false)
    public Long paidAmount;

    @NotEmpty
    @Column(nullable = false)
    public Long balanceAmount;

}
