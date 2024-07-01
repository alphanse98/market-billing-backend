package com.example.billingbackend.repository;

import com.example.billingbackend.entity.Item;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByBusinessID(String businessID);

    @Modifying
    @Transactional
    @Query("UPDATE Item i SET i.itemName = :itemName, i.itemImg = :itemImg, i.isActive = :isActive,  i.itemPrice = :itemPrice WHERE i.id = :id AND i.businessID = :businessID")
    int updateItemByBusinessIDAndId(@Param("itemName") String itemName, @Param("itemImg") String itemImg, @Param("isActive") boolean isActive,  @Param("itemPrice") Double itemPrice, @Param("id") Long id, @Param("businessID") String businessID);


    @Modifying
    @Transactional
    @Query("UPDATE Item i SET  i.isActive = :isActive  WHERE i.id = :id AND i.businessID = :businessID")
    int deleteItem(@Param("isActive") Boolean isActive,@Param("id") Long id, @Param("businessID") String businessID );
}
