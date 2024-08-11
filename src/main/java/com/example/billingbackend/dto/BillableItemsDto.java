package com.example.billingbackend.dto;


import com.example.billingbackend.entity.BillingItemsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillableItemsDto {

//    @Id
//    public Long id;

    public String billingID;

    public String businessID;

    public Long customerID;

    public Long billNumber;


    public String customerName;


    public String date;


    public boolean isActive;


    public Long totalAmount;


    public Long paidAmount;


    public Long balanceAmount;

    private List<BillingItemsEntity> items;
}
