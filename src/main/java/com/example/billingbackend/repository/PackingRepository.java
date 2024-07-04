package com.example.billingbackend.repository;

import com.example.billingbackend.entity.PackingEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PackingRepository extends JpaRepository<PackingEntity,Long> {

    List<PackingEntity> findByBusinessID(String businessID);

    @Modifying
    @Transactional
    @Query("UPDATE PackingEntity i SET i.packingName = :packingName, i.packingPrice = :packingPrice, i.isActive = :isActive,  i.createDate = :createDate WHERE i.id = :id AND i.businessID = :businessID")
    int updatePackingByBusinessIDAndId(@Param("packingName") String packingName, @Param("packingPrice") Double packingPrice, @Param("isActive") boolean isActive, @Param("createDate") String createDate, @Param("id") Long id, @Param("businessID") String businessID);

    @Modifying
    @Transactional
    @Query("UPDATE PackingEntity i SET  i.isActive = :isActive  WHERE i.id = :id AND i.businessID = :businessID")
    void deletePacking(@Param("isActive") Boolean isActive,@Param("id") Long id, @Param("businessID") String businessID );

}
