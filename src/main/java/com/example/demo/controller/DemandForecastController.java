package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demand-forecast")
public class DemandForecastController {

    @GetMapping
    public List<Map<String, Object>> getForecast() {
        return new ArrayList<>();
    }

    @PostMapping
    public Map<String, Object> generateForecast(@RequestBody Map<String, Object> request) {
        return request;
    }
}
