package com.example.billingbackend.repository;

import com.example.billingbackend.entity.CustomerEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    List<CustomerEntity> findByBusinessID(String businessID);

    @Modifying
    @Transactional
    @Query("UPDATE CustomerEntity i SET i.customersName = :customersName, i.mobile = :mobile, i.address = :address, i.secMobile = :secMobile, i.email = :email, i.isActive = :isActive, i.createDate = :createDate WHERE i.id = :id AND i.businessID = :businessID")
    void updateCustomerByBusinessIDAndId(@Param("customersName") String customersName, @Param("mobile") Long mobile, @Param("address") String address, @Param("secMobile") Long secMobile, @Param("email") String email, @Param("isActive") boolean isActive, @Param("createDate") LocalDateTime createDate, @Param("id") Long id, @Param("businessID") String businessID);

    @Modifying
    @Transactional
    @Query("UPDATE CustomerEntity i SET  i.isActive = :isActive  WHERE i.id = :id AND i.businessID = :businessID")
    void deleteCustomer(@Param("isActive") Boolean isActive,@Param("id") Long id, @Param("businessID") String businessID );
}
