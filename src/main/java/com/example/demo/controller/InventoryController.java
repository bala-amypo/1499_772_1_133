package com.example.demo.controller;

import com.example.demo.dto.InventoryRequestDTO;
import com.example.demo.dto.InventoryResponseDTO;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StoreRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    public InventoryController(
            InventoryRepository inventoryRepository,
            ProductRepository productRepository,
            StoreRepository storeRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }

    // ✅ Add inventory
    @PostMapping
    public ResponseEntity<InventoryResponseDTO> addInventory(
            @RequestBody InventoryRequestDTO request) {

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new RuntimeException("Store not found"));

        Inventory inventory = new Inventory();
        inventory.setProduct(product);
        inventory.setStore(store);
        inventory.setQuantity(request.getQuantity());

        Inventory saved = inventoryRepository.save(inventory);

        InventoryResponseDTO response = new InventoryResponseDTO(
                saved.getProduct().getId(),
                saved.getStore().getId(),
                saved.getQuantity()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // ✅ Get all inventory
    @GetMapping
    public ResponseEntity<List<InventoryResponseDTO>> getAllInventory() {

        List<InventoryResponseDTO> response =
                inventoryRepository.findAll()
                        .stream()
                        .map(i -> new InventoryResponseDTO(
                                i.getProduct().getId(),
                                i.getStore().getId(),
                                i.getQuantity()))
                        .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
