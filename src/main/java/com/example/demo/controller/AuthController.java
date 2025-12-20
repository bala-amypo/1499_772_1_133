package com.example.demo.controller;

import com.example.demo.service.AuthService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> register(@RequestBody Map<String, String> body) {
        return ResponseEntity.ok(authService.register(
                body.get("email"),
                body.get("password")
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> body) {
        return ResponseEntity.ok(authService.login(
                body.get("email"),
                body.get("password")
        ));
    }
}
