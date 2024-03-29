package com.example.billingbackend.service.Impl;

import com.example.billingbackend.entity.Item;
import com.example.billingbackend.repository.ItemRepository;
import com.example.billingbackend.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;
    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItems() {
        itemRepository.deleteAll();

    }

    @Override
    public Item findByItemId(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public Item updateItem(Item item) {
        Long id=item.getId();
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
    public List<Item> createItems(List<Item> item) {
        return itemRepository.saveAll(item);
    }
}
