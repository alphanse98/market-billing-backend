package com.example.billingbackend.repository;

import com.example.billingbackend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByBusinessID(String businessID);
}
