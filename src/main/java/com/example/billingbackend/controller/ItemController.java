package com.example.billingbackend.controller;

import com.example.billingbackend.entity.Item;
import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.service.ItemService;
import com.example.billingbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("api/item/")
public class ItemController {
    private ItemService itemService;
    private UserService userService;
    @PostMapping("create")
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        System.out.println("<<<<<<<<<< item  > " + item);
        Item savedItem = itemService.createItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }
    @PostMapping("createItems")
    public ResponseEntity<List<Item>> createItems(@RequestBody List<Item> item){
        List<Item> savedItem = itemService.createItems(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<List<Item>> getAllItems(Principal principal){
        String businessID = userService.findByUserName(principal.getName()).getBusinessID();
        List<Item> savedItems = itemService.getAllItemsBybusinessID(businessID);
        return ResponseEntity.ok().body(savedItems);
    }

    @PostMapping("delete")
    public ResponseEntity<String> deleteItems(@RequestBody Item item){
        itemService.deleteItems(item);
        return new ResponseEntity<>("deleted successfully:",HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Item> userById(@PathVariable("id") Long id){
        Item item = itemService.findByItemId(id);
        return ResponseEntity.ok().body(item);
    }

    @PutMapping("update")
    public ResponseEntity<Item> userUpdate(@RequestBody Item item){
        Item itemUpdated = itemService.updateItembyBusinessID(item);
        return ResponseEntity.ok().body(itemUpdated);
    }
}
