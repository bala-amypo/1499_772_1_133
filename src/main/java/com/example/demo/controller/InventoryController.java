package com.example.demo.controller;

import com.example.demo.dto.InventoryRequestDTO;
import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryLevel createInventory(@RequestBody InventoryRequestDTO dto) {
        return inventoryService.createInventory(
                dto.getProductId(),
                dto.getStoreId(),
                dto.getQuantity()
        );
    }

    @GetMapping
    public List<InventoryLevel> getAllInventory() {
        return inventoryService.getAllInventory();
    }
}
