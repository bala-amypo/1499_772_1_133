package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.impl.InventoryLevelServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryLevelServiceImpl inventoryService;

    public InventoryController(InventoryLevelServiceImpl inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/update")
    public InventoryLevel updateInventory(
            @RequestParam Long storeId,
            @RequestParam Long productId,
            @RequestParam Integer quantity) {
        return inventoryService.updateInventory(storeId, productId, quantity);
    }

    @GetMapping("/{storeId}/{productId}")
    public InventoryLevel getInventory(
            @PathVariable Long storeId,
            @PathVariable Long productId) {
        return inventoryService.getInventory(storeId, productId);
    }

    @GetMapping("/{storeId}")
    public List<InventoryLevel> getInventoryByStore(@PathVariable Long storeId) {
        return inventoryService.getInventoryByStore(storeId);
    }
}
