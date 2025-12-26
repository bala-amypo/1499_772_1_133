package com.example.demo.service;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepo;

    public StoreService(StoreRepository storeRepo) {
        this.storeRepo = storeRepo;
    }

    public Store save(Store store) {
        return storeRepo.save(store);
    }

    public List<Store> getActiveStores() {
        return storeRepo.findByActiveTrue();
    }
}
