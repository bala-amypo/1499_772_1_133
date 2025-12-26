package com.example.demo.service;

import com.example.demo.entity.DemandForecast;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.repository.DemandForecastRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DemandForecastService {

    private final DemandForecastRepository forecastRepo;

    public DemandForecastService(DemandForecastRepository forecastRepo) {
        this.forecastRepo = forecastRepo;
    }

    public DemandForecast save(DemandForecast forecast) {
        return forecastRepo.save(forecast);
    }

    public List<DemandForecast> getByProductAndDate(Product product, LocalDate date) {
        return forecastRepo.findByProductAndForecastDate(product, date);
    }

    public List<DemandForecast> getByStoreAndDate(Store store, LocalDate date) {
        return forecastRepo.findByStoreAndForecastDate(store, date);
    }
}
