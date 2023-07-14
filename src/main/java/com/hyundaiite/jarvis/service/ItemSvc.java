package com.hyundaiite.jarvis.service;

import com.hyundaiite.jarvis.entity.CompanyPositionItem;
import com.hyundaiite.jarvis.entity.Item;
import com.hyundaiite.jarvis.repository.CompanyPositionItemRepo;
import com.hyundaiite.jarvis.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemSvc {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CompanyPositionItemRepo companyPositionItemRepo;

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

    public ArrayList<Item> selectItemsByCompanyPositionId(Long companyPositoinId) {

        ArrayList<Item> items = new ArrayList<>();

        List<CompanyPositionItem> companyPositionItems = companyPositionItemRepo.findByCompanyPositionId(companyPositoinId);

        for(CompanyPositionItem entity : companyPositionItems) {
            Item item = entity.getItem();
            items.add(item);
        }

        return items;

    }
}