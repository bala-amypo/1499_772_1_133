package com.example.demo.service;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserAccountRepository userRepo;

    public AuthService(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    public UserAccount register(RegisterRequestDto dto) {
        UserAccount user = new UserAccount();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        return userRepo.save(user);
    }

    public UserAccount login(AuthRequestDto dto) {
        return userRepo.findByEmail(dto.getEmail())
                .filter(u -> u.getPassword().equals(dto.getPassword()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
