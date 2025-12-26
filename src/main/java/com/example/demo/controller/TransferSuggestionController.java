package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transfer-suggestions")
public class TransferSuggestionController {

    @GetMapping
    public List<Map<String, Object>> getTransferSuggestions() {
        return new ArrayList<>();
    }

    @PostMapping
    public Map<String, Object> createTransferSuggestion(@RequestBody Map<String, Object> request) {
        return request;
    }
}
