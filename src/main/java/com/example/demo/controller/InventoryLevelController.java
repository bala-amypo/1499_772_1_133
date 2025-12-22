package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryLevelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryLevelController {

    private final InventoryLevelService inventoryService;

    public InventoryLevelController(InventoryLevelService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<InventoryLevel> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @PostMapping
    public InventoryLevel addInventory(@RequestBody InventoryLevel inventoryLevel) {
        return inventoryService.addInventory(inventoryLevel);
    }
}
