package com.example.billingbackend.controller;

import com.example.billingbackend.entity.BillingEntity;
import com.example.billingbackend.service.BillingService;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/billing/")
public class BillingController {

    private BillingService billingService;
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<BillingEntity> createBilling(@RequestBody BillingEntity billingTable){
        BillingEntity billingTable1 = billingService.createBilling(billingTable);
        return new ResponseEntity<>(billingTable1, HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<List<BillingEntity>> getAllBillings(Principal principal){
        String businessID = userService.findByUserName(principal.getName()).getBusinessID();
        List<BillingEntity> billingTables = billingService.getAllBillings(businessID);
        return new ResponseEntity<>(billingTables,HttpStatus.OK);
    }


    @PutMapping("update")
    public ResponseEntity<BillingEntity> updateBilling(@RequestBody BillingEntity billingTable){
        BillingEntity updatebilling = billingService.updateBillingByBusinessID(billingTable);
        return new ResponseEntity<>(updatebilling,HttpStatus.OK);
    }

}
