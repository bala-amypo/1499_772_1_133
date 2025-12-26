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

    public InventoryLevel createInventory(Long productId, Long storeId, int quantity) {
        InventoryLevel inventory = new InventoryLevel();

        Product product = new Product();
        product.setId(productId);

        Store store = new Store();
        store.setId(storeId);

        inventory.setProduct(product);
        inventory.setStore(store);
        inventory.setQuantity(quantity);

        return inventoryRepo.save(inventory);
    }

    public List<InventoryLevel> getAllInventory() {
        return inventoryRepo.findAll();
    }
}
