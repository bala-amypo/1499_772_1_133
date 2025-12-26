package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    private final TransferSuggestionRepository transferSuggestionRepository;
    private final InventoryLevelRepository inventoryLevelRepository;
    private final DemandForecastRepository demandForecastRepository;
    private final StoreRepository storeRepository;

    public InventoryBalancerServiceImpl(
            TransferSuggestionRepository transferSuggestionRepository,
            InventoryLevelRepository inventoryLevelRepository,
            DemandForecastRepository demandForecastRepository,
            StoreRepository storeRepository
    ) {
        this.transferSuggestionRepository = transferSuggestionRepository;
        this.inventoryLevelRepository = inventoryLevelRepository;
        this.demandForecastRepository = demandForecastRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public List<TransferSuggestion> generateSuggestions(Long productId) {

        List<InventoryLevel> inventory =
                inventoryLevelRepository.findByProduct_Id(productId);

        if (inventory.isEmpty()) {
            throw new BadRequestException("No inventory found");
        }

        List<TransferSuggestion> suggestions = new ArrayList<>();

        for (InventoryLevel source : inventory) {
            for (InventoryLevel target : inventory) {

                if (!source.getStore().getId().equals(target.getStore().getId())
                        && source.getQuantity() > target.getQuantity()) {

                    List<DemandForecast> forecasts =
                            demandForecastRepository.findByStoreAndProductAndForecastDateAfter(
                                    target.getStore(),
                                    target.getProduct(),
                                    LocalDate.now()
                            );

                    if (forecasts.isEmpty()) {
                        throw new BadRequestException("No forecast found");
                    }

                    TransferSuggestion ts = new TransferSuggestion();
                    ts.setSourceStore(source.getStore());
                    ts.setTargetStore(target.getStore());
                    ts.setProduct(source.getProduct());
                    ts.setSuggestedQuantity(
                            (source.getQuantity() - target.getQuantity()) / 2
                    );
                    ts.setReason("Auto balance");

                    suggestions.add(
                            transferSuggestionRepository.save(ts)
                    );
                }
            }
        }
        return suggestions;
    }

    @Override
    public List<TransferSuggestion> getSuggestionsForStore(Long storeId) {
        return transferSuggestionRepository.findBySourceStore_Id(storeId);
    }

    @Override
    public TransferSuggestion getSuggestionById(Long id) {
        return transferSuggestionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Suggestion not found"));
    }
}
