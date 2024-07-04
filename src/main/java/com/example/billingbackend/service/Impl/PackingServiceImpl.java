package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.PackingEntity;
import com.example.billingbackend.repository.PackingRepository;
import com.example.billingbackend.service.PackingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PackingServiceImpl implements PackingService {

    private PackingRepository packingRepository;
    @Override
    public PackingEntity create(PackingEntity packingEntity) {
        return packingRepository.save(packingEntity);
    }

    @Override
    public List<PackingEntity> getAllPackingBybusinessID(String businessID) {
        return packingRepository.findByBusinessID(businessID);
    }

    @Override
    public PackingEntity updatePackingByBusinessID(PackingEntity packingEntity) {
        packingRepository.updatePackingByBusinessIDAndId(
                packingEntity.getPackingName(),
                packingEntity.getPackingPrice(),
                packingEntity.isActive(),
                packingEntity.getCreateDate(),
                packingEntity.getId(),
                packingEntity.getBusinessID()
        );
        return packingEntity;
    }

    @Override
    public void deletePackings(PackingEntity packingEntity) {
//        System.out.println(">>>>>>>>>>>>>>" + packingEntity);
        packingRepository.deletePacking(false, packingEntity.getId(), packingEntity.getBusinessID());
    }






















}
