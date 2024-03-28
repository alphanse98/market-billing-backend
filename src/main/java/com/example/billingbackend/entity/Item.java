package com.example.billingbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long businessID;
    @Column(nullable = false)
    private String itemName;
    @Column(nullable = false)
    private String itemImg;
    @Column(nullable = false)
    private Double itemPrice;
//    private boolean isActive;
    @Column(nullable = false)
    private Date createDate;




}
