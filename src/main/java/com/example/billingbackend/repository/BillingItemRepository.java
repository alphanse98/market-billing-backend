package com.example.billingbackend.repository;

import com.example.billingbackend.entity.BillingItemsEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillingItemRepository extends JpaRepository<BillingItemsEntity,Long> {

//    @Modifying
//    @Transactional
//    @Query("UPDATE BillingItemsEntity i SET  i.id = :id, i.itemName = :itemName, i.itemPrice = :itemPrice, i.isActive = :isActive, i.quantity = :quantity, i.totalAmount = :totalAmount  WHERE  i.createDate = :createDate AND i.businessID = :businessID AND i.billingNumber = :billingNumber")
//    void deleteBillingItems(@Param("id") Long id,@Param("itemName") String itemName, @Param("itemPrice") Long itemPrice, @Param("isActive") Boolean isActive, @Param("quantity") Long quantity, @Param("totalAmount") Long totalAmount, @Param("createDate") String createDate, @Param("businessID") String businessID, @Param("billingNumber") Long billingNumber );



    @Transactional
    @Modifying
    @Query("DELETE FROM BillingItemsEntity i WHERE i.businessID = ?1 AND i.billingNumber = ?2")
    void deleteByBusinessIdAndBillingNumber(String businessID, Long billingNumber);

}
