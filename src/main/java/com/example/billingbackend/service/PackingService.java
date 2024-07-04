package com.example.billingbackend.service;

import com.example.billingbackend.entity.Item;
import com.example.billingbackend.entity.PackingEntity;

import java.util.List;

public interface PackingService {

    PackingEntity create(PackingEntity packingEntity);

    List<PackingEntity> getAllPackingBybusinessID(String businessID);

    PackingEntity updatePackingByBusinessID(PackingEntity packingEntity);

    void deletePackings(PackingEntity packingEntity);

}
