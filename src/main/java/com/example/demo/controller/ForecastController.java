package com.example.demo.controller;

import com.example.demo.entity.DemandForecast;
import com.example.demo.service.impl.DemandForecastServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forecasts")
public class ForecastController {

    private final DemandForecastServiceImpl forecastService;

    public ForecastController(DemandForecastServiceImpl forecastService) {
        this.forecastService = forecastService;
    }

    @PostMapping
    public DemandForecast createForecast(@RequestBody DemandForecast forecast) {
        return forecastService.createForecast(forecast);
    }

    @GetMapping("/{storeId}/{productId}")
    public DemandForecast getForecast(
            @PathVariable Long storeId,
            @PathVariable Long productId) {
        return forecastService.getForecast(storeId, productId);
    }
}
