package com.example.billingbackend.controller;

import com.example.billingbackend.entity.BillingEntity;
import com.example.billingbackend.entity.BillingItemsEntity;
import com.example.billingbackend.service.BillingItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/billingItems/")
public class BillingItemController {

    private BillingItemService billingItemService;

    @PostMapping("create")
    public ResponseEntity<List<BillingItemsEntity>> createbillingitems(@RequestBody List<BillingItemsEntity> billingItemsEntity){
        List<BillingItemsEntity> billingItemsEntity1=billingItemService.createbillingitems(billingItemsEntity);
        return new ResponseEntity<>(billingItemsEntity1, HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<List<BillingItemsEntity>> getAllBillingItems(){
        List<BillingItemsEntity> billingItemsEntities=billingItemService.getAllBillingItems();
        return new ResponseEntity<>(billingItemsEntities,HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<BillingItemsEntity> updateBillingItems(@RequestBody BillingItemsEntity billingItemsEntity){
        BillingItemsEntity billingItems=billingItemService.updateBillingItems(billingItemsEntity);
        return new ResponseEntity<>(billingItems,HttpStatus.OK);
    }
}
