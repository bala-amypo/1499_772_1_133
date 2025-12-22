package com.example.demo.controller;

import com.example.demo.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<Product> getAllProducts() {
        return new ArrayList<>(); // dummy list
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return product; // echo back
    }
}
