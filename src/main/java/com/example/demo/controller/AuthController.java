package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> request) {
        // expected JSON:
        // { "email": "...", "password": "..." }
        return "User registered successfully";
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {
        // expected JSON:
        // { "email": "...", "password": "..." }
        return "Login successful";
    }
}
