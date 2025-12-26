package com.example.demo.service;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.repository.InventoryLevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryLevelRepository inventoryRepo;

    public InventoryService(InventoryLevelRepository inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public InventoryLevel save(InventoryLevel inventory) {
        return inventoryRepo.save(inventory);
    }

    public List<InventoryLevel> getByProduct(Product product) {
        return inventoryRepo.findByProduct(product);
    }

    public List<InventoryLevel> getByStore(Store store) {
        return inventoryRepo.findByStore(store);
    }
}
