package com.example.billingbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "billingItems")
public class BillingItemsEntity {
    @Id
    @Column(nullable = false)
    private String billNumber;

    @Column(nullable = false)
    private String businessID;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private Long itemPrice;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String createDate;

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Long totalAmount;

}
