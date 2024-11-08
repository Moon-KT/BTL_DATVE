package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.RegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String login(String email, String password);
    String register(RegisterDto registerDto);
    String resetPassword(String email, String newPassword);
    void logout();
}
