package com.example.billingbackend.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String billingID;

    @Column(nullable = false)
    public String businessID;

    @Column(nullable = false)
    public Long customerID;

    @Column(nullable = false,unique = true)
    public String billNumber;

    @NotEmpty
    @Column(nullable = false)
    public String customerName;

    @Column(nullable = false)
    public String date;

    @JsonProperty("isActive")
    @Column(nullable = false)
    public boolean isActive;

    @Column(nullable = false)
    public Long totalAmount;

    @Column(nullable = false)
    public Long paidAmount;

    @Column(nullable = false)
    public Long balanceAmount;

}
