package com.example.billingbackend.service;

import com.example.billingbackend.dto.BillableItemsDto;
import com.example.billingbackend.entity.BillingItemsEntity;

import java.util.List;

public interface BillableItemsService {

    void saveBillableItems(BillableItemsDto billableItemsDto);

    void updateBillableItemsByBusinessID(BillableItemsDto billableItemsDto);




}
