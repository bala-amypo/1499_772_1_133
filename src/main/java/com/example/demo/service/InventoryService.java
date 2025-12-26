package com.example.demo.service;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryLevelRepository inventoryRepo;
    private final ProductRepository productRepo;
    private final StoreRepository storeRepo;

    public InventoryService(InventoryLevelRepository inventoryRepo,
                            ProductRepository productRepo,
                            StoreRepository storeRepo) {
        this.inventoryRepo = inventoryRepo;
        this.productRepo = productRepo;
        this.storeRepo = storeRepo;
    }

    public InventoryLevel createInventory(Long productId, Long storeId, int quantity) {

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Store store = storeRepo.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));

        InventoryLevel inventory = new InventoryLevel();
        inventory.setProduct(product);
        inventory.setStore(store);
        inventory.setQuantity(quantity);

        return inventoryRepo.save(inventory);
    }

    public List<InventoryLevel> getAllInventory() {
        return inventoryRepo.findAll();
    }
}


