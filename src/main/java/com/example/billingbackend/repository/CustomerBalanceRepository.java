package com.example.billingbackend.repository;

import com.example.billingbackend.entity.CustomerBalanceEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomerBalanceRepository extends JpaRepository<CustomerBalanceEntity, Long> {
    List<CustomerBalanceEntity> findByBusinessID(String businessID);

    @Modifying
    @Transactional
    @Query("UPDATE CustomerBalanceEntity i SET i.balanceAmount = :balanceAmount WHERE i.id = :id AND i.businessID = :businessID")
    void updateCustomerBalanceByBusinessIDAndId(@Param("balanceAmount") Long balanceAmount, @Param("id") Long id, @Param("businessID") String businessID);

    @Modifying
    @Transactional
    @Query("UPDATE CustomerBalanceEntity i SET  i.isActive = :isActive  WHERE i.id = :id AND i.businessID = :businessID")
    int deleteCustomerBalance(@Param("isActive") Boolean isActive,@Param("id") Long id, @Param("businessID") String businessID );

}
