package com.example.billingbackend.service;


import com.example.billingbackend.entity.BillSettings;

import java.util.List;

public interface BillSettingsService {

    BillSettings addBillSettings(BillSettings billSettings);

    List<BillSettings> getBillSettings(String businessID);

   BillSettings updateBillSettingsByBusinessID(BillSettings billSettings);

}
