package com.example.billingbackend.service.Impl;

import com.example.billingbackend.dto.BillableItemsDto;
import com.example.billingbackend.service.BillableItemsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class   BillableItemsServiceImp implements BillableItemsService {

    @Override
    public void saveBillableItems(BillableItemsDto billableItemsDto) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< billableItemsDto == " + billableItemsDto);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< billableItemsDto == " + billableItemsDto.getItems());

//        split data using model mapper

//        split data like BillingEntity ===>  save the data to billing table

//        split data like BillingItemsEntity ( billableItemsDto.getItems()) ===>  saveAll the data to billingItems table
    }
}
