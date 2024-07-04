package com.example.billingbackend.controller;


import com.example.billingbackend.entity.PackingEntity;
import com.example.billingbackend.repository.PackingRepository;
import com.example.billingbackend.service.PackingService;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/packing/")
public class PackingController {

    @Autowired
    private PackingService packingService;
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<PackingEntity> createPackingEntity(@RequestBody PackingEntity packingEntity){
        PackingEntity createPackingEntities = packingService.create(packingEntity);
        return new ResponseEntity<>(createPackingEntities, HttpStatus.CREATED);
    }


    @GetMapping("get")
    public ResponseEntity<List<PackingEntity>> getAllPacking(Principal principal){
        String businessID = userService.findByUserName(principal.getName()).getBusinessID();
        List<PackingEntity> packingEntityList = packingService.getAllPackingBybusinessID(businessID);
        return new ResponseEntity<>(packingEntityList,HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<PackingEntity> updatePacking(@RequestBody PackingEntity packingEntity){
        PackingEntity updatedPacking = packingService.updatePackingByBusinessID(packingEntity);
        return new ResponseEntity<>(updatedPacking, HttpStatus.OK);
    }


    @DeleteMapping("delete")
    public ResponseEntity<String> deletePacking(@RequestBody PackingEntity packingEntity){
        System.out.println(">>>>>>>>>>>>>>" + packingEntity);
        packingService.deletePackings(packingEntity);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }



}
