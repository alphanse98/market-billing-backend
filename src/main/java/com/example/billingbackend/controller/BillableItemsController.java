package com.example.billingbackend.controller;

import com.example.billingbackend.dto.BillableItemsDto;
import com.example.billingbackend.entity.BillingEntity;
import com.example.billingbackend.service.BillableItemsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/billableItems/")
public class BillableItemsController {

    private  BillableItemsService billableItemsService;
    @PostMapping("create")
    public ResponseEntity<String> createBilling(@RequestBody BillableItemsDto billableItemsDto){
        billableItemsService.saveBillableItems(billableItemsDto);

        return  new ResponseEntity<>("ok",HttpStatus.OK);
    }


}
