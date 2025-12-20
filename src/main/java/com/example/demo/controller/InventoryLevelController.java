package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryLevelController {

    @GetMapping
    public String getInventoryLevels() {
        return "Inventory levels fetched";
    }

    @PostMapping
    public String updateInventory() {
        return "Inventory updated";
    }
}
