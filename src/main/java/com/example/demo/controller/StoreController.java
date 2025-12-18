package com.example.demo.controller;

import com.example.demo.entity.Store;
import com.example.demo.service.impl.StoreServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreServiceImpl storeService;

    public StoreController(StoreServiceImpl storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return storeService.createStore(store);
    }

    @GetMapping("/{id}")
    public Store getStore(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }
}
