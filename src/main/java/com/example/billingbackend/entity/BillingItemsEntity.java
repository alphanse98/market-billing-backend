package com.example.billingbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @Column(nullable = false, unique = true)
    private String billNumber;

    @NotEmpty
    @Column(nullable = false)
    private String businessID;

    @NotEmpty
    @Size(max = 15, message = "item name should have atmost 15 characters")
    @Column(nullable = false)
    private String itemName;

    @NotEmpty
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
