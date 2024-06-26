package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.BillSettings;
import com.example.billingbackend.repository.BillSettingsRepository;
import com.example.billingbackend.service.BillSettingsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillSettingsServiceImpl implements BillSettingsService {

    public BillSettingsRepository billSettingsRepository;


    @Override
    public BillSettings addBillSettings(BillSettings billSettings) {
        return billSettingsRepository.save(billSettings);
    }

    @Override
    public List<BillSettings> getBillSettings(String businessID) {
        return billSettingsRepository.findByBusinessID(businessID);
    }

    @Override
    public BillSettings updateBillSettingsByBusinessID(BillSettings billSettings) {
        billSettingsRepository.updateBillSettingsByBusinessIDAndId(
                billSettings.getBrandName(),
                billSettings.getAddress(),
                billSettings.getMobile(),
                billSettings.getSecMobile(),
                billSettings.getEmail(),
                billSettings.isCustomerID(),
                billSettings.isCustomerName(),
                billSettings.getId(),
                billSettings.getBusinessID()
        );
        return billSettings;
    }


}
