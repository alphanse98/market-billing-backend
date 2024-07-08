package com.example.billingbackend.service.Impl;

import com.example.billingbackend.dto.BillableItemsDto;
import com.example.billingbackend.entity.BillingEntity;
import com.example.billingbackend.entity.BillingItemsEntity;
import com.example.billingbackend.repository.BillingItemRepository;
import com.example.billingbackend.repository.BillingRepository;
import com.example.billingbackend.service.BillableItemsService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class   BillableItemsServiceImp implements BillableItemsService {

    private ModelMapper modelMapper;
    private BillingRepository billingRepository;
    private BillingItemRepository billingItemRepository;

    @Override
    @Transactional
    public void saveBillableItems(BillableItemsDto billableItemsDto) {
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< billableItemsDto == " + billableItemsDto);
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< billableItemsDto == " + billableItemsDto.getItems());

//        if (billableItemsDto.getItems() == null) {
//            throw new IllegalArgumentException("Items list cannot be null");
//        }

        // Map BillableItemsDto to BillingEntity
        BillingEntity billingEntity = modelMapper.map(billableItemsDto, BillingEntity.class);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+billingEntity);

        // Save BillingEntity
//        BillingEntity savedBillingEntity = billingRepository.save(billingEntity);

//        // Map List<BillingItemsEntity> from BillableItemsDto.getItems()
//        List<BillingItemsEntity> billingItemsEntities = billableItemsDto.getItems().stream()
//                .map(itemDto -> modelMapper.map(itemDto, BillingItemsEntity.class))
//                .peek(entity -> entity.setBillingNumber(savedBillingEntity.getId())) // Set the billingNumber from saved BillingEntity
//                .collect(Collectors.toList());
//
//        // Save all BillingItemsEntity
//        billingItemRepository.saveAll(billingItemsEntities);

//        split data using model mapper

//        split data like BillingEntity ===>  save the data to billing table

//        split data like BillingItemsEntity ( billableItemsDto.getItems()) ===>  saveAll the data to billingItems table
    }
}
