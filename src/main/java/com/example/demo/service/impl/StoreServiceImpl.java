package com.example.demo.service.impl;

import com.example.demo.entity.Store;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store createStore(Store store) {
        storeRepository.findByStoreName(store.getStoreName())
                .ifPresent(s -> {
                    throw new BadRequestException("Store name already exists");
                });
        return storeRepository.save(store);
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
}
