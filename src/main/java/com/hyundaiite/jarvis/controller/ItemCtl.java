package com.hyundaiite.jarvis.controller;

import com.hyundaiite.jarvis.entity.Item;
import com.hyundaiite.jarvis.service.ItemSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/items")
public class ItemCtl {
    @Autowired
    private ItemSvc itemSvc;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveItem(@RequestBody Item item) {
        Item savedItem = itemSvc.saveItem(item);
        return savedItem.getId();
    }

    @GetMapping("")
    public List<Item> selectItems() {
        List<Item> selectedItems = itemSvc.selectItems();
        return selectedItems;
    }

    @GetMapping("/{id}")
    public Item selectItems(@PathVariable Long id) {
        Item selectedItem = itemSvc.selectItem(id).orElseThrow();
        return selectedItem;
    }

    @PutMapping("/{id}")
    public Long updateItem(@RequestBody Item item) {
        Item updatedItem = itemSvc.saveItem(item);
        return updatedItem.getId();
    }

    @DeleteMapping("/{id}")
    public Long deleteItem(@PathVariable Long id) {
        return itemSvc.deleteItem(id);
    }

    @GetMapping("/company/{company_positoin_id}")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Item> selectItemsByCompanyPositionId(@PathVariable Long company_positoin_id) {
        ArrayList<Item> items = itemSvc.selectItemsByCompanyPositionId(company_positoin_id);
        return items;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}