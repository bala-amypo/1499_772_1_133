package com.example.demo.controller;

import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> body) {
        return authService.register(
                body.get("email"),
                body.get("password")
        );
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body) {
        return authService.login(
                body.get("email"),
                body.get("password")
        );
    }
}
