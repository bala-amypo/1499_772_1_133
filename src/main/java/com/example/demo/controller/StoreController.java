package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @GetMapping
    public String getAllStores() {
        return "Stores fetched";
    }

    @PostMapping
    public String createStore() {
        return "Store created";
    }
}
