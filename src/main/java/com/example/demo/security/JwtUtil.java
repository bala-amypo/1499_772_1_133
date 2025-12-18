package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email) {
        return "dummy-jwt-token-for-" + email;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("dummy-jwt-token-for-");
    }

    public String extractUsername(String token) {
        return token.replace("dummy-jwt-token-for-", "");
    }
}
