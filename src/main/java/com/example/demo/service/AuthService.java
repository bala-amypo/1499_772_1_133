package com.example.demo.service;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserAccountRepository userRepo;
    private final JwtUtil jwtUtil;

    public AuthService(UserAccountRepository userRepo, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.jwtUtil = jwtUtil;
    }

    public String register(RegisterRequestDto dto) {
        UserAccount user = new UserAccount();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        userRepo.save(user);
        return jwtUtil.generateToken(user.getEmail());
    }

    public String login(AuthRequestDto dto) {
        UserAccount user = userRepo.findByEmail(dto.getEmail())
                .filter(u -> u.getPassword().equals(dto.getPassword()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        return jwtUtil.generateToken(user.getEmail());
    }
}
