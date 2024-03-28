package com.example.billingbackend.service;

import com.example.billingbackend.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();
    Item createItem(Item item);
    void deleteItems();
    Item findByItemId(Long id);
    Item updateItem(Item item);
}
