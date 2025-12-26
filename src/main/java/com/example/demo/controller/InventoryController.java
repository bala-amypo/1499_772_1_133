package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // Create inventory record
    @PostMapping
    public InventoryLevel createInventory(@RequestParam Long productId,
                                          @RequestParam Long storeId,
                                          @RequestParam int quantity) {

        InventoryLevel inventory = new InventoryLevel();

        Product product = new Product();
        product.setId(productId);

        Store store = new Store();
        store.setId(storeId);

        inventory.setProduct(product);
        inventory.setStore(store);
        inventory.setQuantity(quantity);

        return inventoryService.save(inventory);
    }

    // Get all inventory
    @GetMapping
    public List<InventoryLevel> getAllInventory() {
        return inventoryService.findAll();
    }
}
