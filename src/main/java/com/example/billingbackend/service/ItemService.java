package com.example.billingbackend.service;

import com.example.billingbackend.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> getAllItemsBybusinessID(String businessID);
    Item createItem(Item item);
    void deleteItems(Item item);
    Item findByItemId(Long id);
    Item updateItem(Item item);

    Item updateItembyBusinessID(Item item);

    List<Item> createItems(List<Item> item);


}
