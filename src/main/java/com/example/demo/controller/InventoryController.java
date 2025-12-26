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

    @PostMapping
    public InventoryLevel createInventory(@RequestBody InventoryLevel inventoryLevel) {
        return inventoryService.save(inventoryLevel);
    }

    @GetMapping("/product/{productId}")
    public List<InventoryLevel> getByProduct(@PathVariable Long productId) {
        Product product = new Product();
        product.setId(productId);
        return inventoryService.getByProduct(product);
    }

    @GetMapping("/store/{storeId}")
    public List<InventoryLevel> getByStore(@PathVariable Long storeId) {
        Store store = new Store();
        store.setId(storeId);
        return inventoryService.getByStore(store);
    }
}
