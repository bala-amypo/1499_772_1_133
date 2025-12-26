package com.example.demo.service;

import com.example.demo.entity.InventoryLevel;
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

    public List<InventoryLevel> findAll() {
        return inventoryRepo.findAll();
    }
}
