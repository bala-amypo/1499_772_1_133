package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    
    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> request) {
       
        return "User registered successfully";
    }

  
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {
        
        return "Login successful";
    }
}
