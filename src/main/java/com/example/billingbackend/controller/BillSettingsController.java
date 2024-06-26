package com.example.billingbackend.controller;

import com.example.billingbackend.entity.BillSettings;
import com.example.billingbackend.service.BillSettingsService;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("api/billsettings/")
public class BillSettingsController {

    private BillSettingsService billSettingsService;
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<BillSettings> addBillSettings(@RequestBody  BillSettings billSettings){
        BillSettings addbillSettings = billSettingsService.addBillSettings(billSettings);
        return new ResponseEntity<>(addbillSettings, HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<List<BillSettings>> getBillSettings(Principal principal){
        String businessId = userService.findByUserName(principal.getName()).getBusinessID();
        List<BillSettings> billSettingsList = billSettingsService.getBillSettings(businessId);
        return new ResponseEntity<>(billSettingsList,HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<BillSettings> updateBillSettings(@RequestBody BillSettings billSettings){
        BillSettings updateBillSettings = billSettingsService.updateBillSettingsByBusinessID(billSettings);
        return new ResponseEntity<>(updateBillSettings,HttpStatus.OK);
    }
}
