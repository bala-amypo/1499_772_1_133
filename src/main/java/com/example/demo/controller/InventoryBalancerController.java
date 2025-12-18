package com.example.demo.controller;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.service.impl.InventoryBalancerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/balancer")
public class InventoryBalancerController {

    private final InventoryBalancerServiceImpl balancerService;

    public InventoryBalancerController(InventoryBalancerServiceImpl balancerService) {
        this.balancerService = balancerService;
    }

    @PostMapping("/generate/{productId}")
    public String generate(@PathVariable Long productId) {
        balancerService.generateSuggestions(productId);
        return "Suggestions generated";
    }

    @GetMapping("/store/{storeId}")
    public List<TransferSuggestion> getForStore(@PathVariable Long storeId) {
        return balancerService.getSuggestionsForStore(storeId);
    }

    @GetMapping("/{id}")
    public TransferSuggestion getById(@PathVariable Long id) {
        return balancerService.getSuggestionById(id);
    }
}
