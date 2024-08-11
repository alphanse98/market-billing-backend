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
    private  BillingRepository billingRepository;
    private BillingItemRepository billingItemRepository;

    @Override
    @Transactional
    public void saveBillableItems(BillableItemsDto request) {
        //
        BillingEntity billData = new BillingEntity();
        billData.setBusinessID(request.getBusinessID());
        billData.setBillingID(request.getBillingID());
        billData.setCustomerID(request.getCustomerID());
        billData.setBillNumber(request.getBillNumber());
        billData.setCustomerName(request.getCustomerName());
        billData.setDate(request.getDate());
        billData.setActive(true);
        billData.setTotalAmount(request.getTotalAmount());
        billData.setPaidAmount(request.getPaidAmount());
        billData.setBalanceAmount(request.getBalanceAmount());

        billingRepository.save(billData);

        List<BillingItemsEntity> billingItemsEntities = request.getItems();
        billingItemRepository.saveAll(billingItemsEntities);
    }

    @Override
    public void updateBillableItemsByBusinessID(BillableItemsDto billableItemsDto) {

        String businessID = billableItemsDto.getBusinessID();
        Long billNumber= billableItemsDto.getBillNumber();
        billingItemRepository.deleteByBusinessIdAndBillingNumber(businessID, billNumber);

        // add billing items to database (saveAll)
        // update billing based on businessID and billNumber

        billingRepository.updateByBusinessIdAndBillingNumber(billableItemsDto.getBillingID(),billableItemsDto.getCustomerID(),billableItemsDto.getCustomerName(),billableItemsDto.getDate(),billableItemsDto.isActive(),billableItemsDto.getTotalAmount(),billableItemsDto.getPaidAmount(),billableItemsDto.getBalanceAmount(),billableItemsDto.getBillNumber(),billableItemsDto.getBusinessID());

        List<BillingItemsEntity> billingItemsEntityList = billableItemsDto.getItems();
        billingItemRepository.saveAll(billingItemsEntityList);

    }



}
