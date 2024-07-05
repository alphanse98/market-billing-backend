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
@Table(name = "billingItems")
public class BillingItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String businessID;

    @NotEmpty
//    @Size(max = 15, message = "item name should have atmost 15 characters")
    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private Long itemPrice;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String createDate;

    @Column(nullable = false)
    private Long billingNumber;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Long totalAmount;

}
