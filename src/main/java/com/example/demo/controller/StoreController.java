package com.example.demo.controller;

import com.example.demo.entity.Store;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @GetMapping
    public List<Store> getAllStores() {
        return new ArrayList<>();
    }

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return store;
    }
}
