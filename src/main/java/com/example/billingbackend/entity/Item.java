package com.example.billingbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "items", indexes = {
        @Index(name = "idx_business_id", columnList = "businessID")
})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String businessID;

    @NotEmpty
    @Size(max = 15, message = "item name should have atmost 15 characters")
    @Column(nullable = false)
    private String itemName;

    @NotEmpty
    @Column(nullable = false)
    private String itemImg;

    @NotEmpty
    @Column(nullable = false)
    private Double itemPrice;

    @NotEmpty
    private boolean isActive;

    @NotEmpty
    @Column(nullable = true) // Setting nullable to true makes the column optional
    private Date createDate;
}



