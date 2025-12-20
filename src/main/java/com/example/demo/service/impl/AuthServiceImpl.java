package com.example.demo.service.impl;

import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    // Simple in-memory storage
    private final Map<String, String> users = new HashMap<>();

    @Override
    public String register(String email, String password) {
        if (users.containsKey(email)) {
            return "User already exists";
        }
        users.put(email, password);
        return "User registered successfully";
    }

    @Override
    public String login(String email, String password) {
        if (!users.containsKey(email)) {
            return "User not found";
        }
        if (!users.get(email).equals(password)) {
            return "Invalid credentials";
        }
        return "Login successful";
    }
}
