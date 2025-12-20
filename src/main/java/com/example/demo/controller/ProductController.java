package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public String getAllProducts() {
        return "Products fetched";
    }

    @PostMapping
    public String createProduct() {
        return "Product created";
    }
}
