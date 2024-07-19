package com.example.billingbackend.repository;

import com.example.billingbackend.entity.BillingEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillingRepository extends JpaRepository<BillingEntity,Long> {

    List<BillingEntity> findByBusinessID(String businessID);

    @Modifying
    @Transactional
    @Query("UPDATE BillingEntity i SET i.billingID = :billingID, i.customerID =:customerID, i.billNumber= :billNumber, i.customerName = :customerName, i.date = :date, i.isActive = :isActive, i.totalAmount = :totalAmount, i.paidAmount = :paidAmount, i.balanceAmount= :balanceAmount WHERE i.id = :id AND i.businessID = :businessID")
    int updateBillingByBusinessIDandId(@Param("billingID") String billingID, @Param("customerID") Long customerID, @Param("billNumber") Long billNumber, @Param("customerName") String customerName, @Param("date") String date, @Param("isActive") boolean isActive, @Param("totalAmount") Long totalAmount, @Param("paidAmount") Long paidAmount, @Param("balanceAmount") Long balanceAmount, @Param("id") Long id, @Param("businessID") String businessID);


    @Transactional
    @Modifying
    @Query("UPDATE BillingEntity i SET  i.billingID = :billingID, i.customerID =:customerID, i.customerName = :customerName, i.date = :date, i.isActive = :isActive, i.totalAmount = :totalAmount, i.paidAmount = :paidAmount, i.balanceAmount= :balanceAmount WHERE i.billNumber= :billNumber AND i.businessID = :businessID")
    void updateByBusinessIdAndBillingNumber( @Param("billingID") String billingID, @Param("customerID") Long customerID, @Param("customerName") String customerName, @Param("date") String date, @Param("isActive") boolean isActive, @Param("totalAmount") Long totalAmount, @Param("paidAmount") Long paidAmount, @Param("balanceAmount") Long balanceAmount, @Param("billNumber") Long billNumber, @Param("businessID") String businessID);




}
