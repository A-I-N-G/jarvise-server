package com.hyundaiite.jarvis.service;

import com.hyundaiite.jarvis.entity.Item;
import com.hyundaiite.jarvis.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemSvc {

    @Autowired
    private ItemRepo itemRepo;

    public Item saveItem(Item item) {
        return itemRepo.save(item);
    }

    public List<Item> selectItems() {
        return itemRepo.findAll();
    }

    public Long deleteItem(Long id) {
        itemRepo.deleteById(id);
        return id;
    }

    public Optional<Item> selectItem(Long id) {
        return itemRepo.findById(id);
    }
}