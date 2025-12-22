package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryLevelController {

    @GetMapping
    public List<InventoryLevel> getAllInventory() {
        return new ArrayList<>(); // dummy response
    }

    @PostMapping
    public InventoryLevel addInventory(@RequestBody InventoryLevel inventoryLevel) {
        return inventoryLevel; // echo back request
    }
}
