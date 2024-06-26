package com.example.billingbackend.repository;

import com.example.billingbackend.entity.BillSettings;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BillSettingsRepository extends JpaRepository<BillSettings,Long> {

    List<BillSettings> findByBusinessID(String businessID);

    @Modifying
    @Transactional
    @Query("UPDATE BillSettings i SET i.brandName = :brandName, i.address = :address, i.mobile = :mobile,  i.secMobile = :secMobile, i.email = :email, i.customerID = :customerID, i.customerName = :customerName WHERE i.id = :id AND i.businessID = :businessID")
    void updateBillSettingsByBusinessIDAndId(@Param("brandName") String brandName, @Param("address") String address, @Param("mobile") Long mobile,  @Param("secMobile") Long secMobile, @Param("email") String email, @Param("customerID") boolean customerID, @Param("customerName") boolean customerName, @Param("id") Long id, @Param("businessID") String businessID);
}
