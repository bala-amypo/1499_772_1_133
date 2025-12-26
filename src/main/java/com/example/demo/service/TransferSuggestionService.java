package com.example.demo.service;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.repository.TransferSuggestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferSuggestionService {

    private final TransferSuggestionRepository transferRepo;

    public TransferSuggestionService(TransferSuggestionRepository transferRepo) {
        this.transferRepo = transferRepo;
    }

    public TransferSuggestion save(TransferSuggestion suggestion) {
        return transferRepo.save(suggestion);
    }

    public List<TransferSuggestion> getByProductId(Long productId) {
        return transferRepo.findByProductId(productId);
    }
}
