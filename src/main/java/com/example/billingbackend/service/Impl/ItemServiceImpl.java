package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.Item;
import com.example.billingbackend.repository.ItemRepository;
import com.example.billingbackend.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItemsBybusinessID(String businessID) {
        return itemRepository.findByBusinessID(businessID);
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItems(Item item) {
        itemRepository.deleteItem(false,item.getId(), item.getBusinessID());
    }

    @Override
    public Item findByItemId(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public Item updateItem(Item item) {
        Long id = item.getId();
        Item itemfinded = itemRepository.findById(id).get();

        itemfinded.setBusinessID(item.getBusinessID());
        itemfinded.setItemName(item.getItemName());
        itemfinded.setItemImg(item.getItemImg());
        itemfinded.setItemPrice(item.getItemPrice());
        itemfinded.setCreateDate(item.getCreateDate());


        itemRepository.save(itemfinded);
        return itemfinded;
    }

    @Override
    public Item updateItembyBusinessID(Item item) {

        itemRepository.updateItemByBusinessIDAndId(
                item.getItemName(),
                item.getItemImg(),
                item.isActive(),
                item.getCreateDate(),
                item.getItemPrice(),
                item.getId(),
                item.getBusinessID()
        );

        return item;
    }

    @Override
    public List<Item> createItems(List<Item> item) {
        return itemRepository.saveAll(item);
    }
}
