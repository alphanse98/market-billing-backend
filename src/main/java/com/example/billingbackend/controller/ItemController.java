package com.example.billingbackend.controller;

import com.example.billingbackend.entity.Item;
import com.example.billingbackend.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/item/")
public class ItemController {
    private ItemService itemService;
    @PostMapping("create")
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        item.setCreateDate(new Date());
        Item savedItem = itemService.createItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @PostMapping("createItems")
    public ResponseEntity<List<Item>> createItems(@RequestBody List<Item> item){
        List<Item> savedItem = itemService.createItems(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> savedItems = itemService.getAllItems();
        return ResponseEntity.ok().body(savedItems);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteItems(){
        itemService.deleteItems();
        return new ResponseEntity<>("deleted successfully:",HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> userById(@PathVariable("id") Long id){
        Item item = itemService.findByItemId(id);
        return ResponseEntity.ok().body(item);
    }

    @PutMapping("update")
    public ResponseEntity<Item> userUpdate(@RequestBody Item item){
        Item itemUpdated = itemService.updateItem(item);
        return ResponseEntity.ok().body(itemUpdated);
    }
}
