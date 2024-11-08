package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.RegisterDto;
import com.example.SB_Week9.entity.User;
import com.example.SB_Week9.entity.enumModel.UserRole;
import com.example.SB_Week9.repository.UserRepository;
import com.example.SB_Week9.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;

@Component
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(String username, String password) {
        if(userRepository.findByEmail(username).getPassword().equals(passwordEncoder.encode(password))) {
            return "Login success";
        }

        return "Invalid username or password!";
    }

    @Override
    public String register(RegisterDto registerDto) {
        if (userRepository.findByEmail(registerDto.getEmail()) != null) {
            return "Username already exists!";
        }

        User user = User.builder()
                .username(registerDto.getUsername())
                .password(registerDto.getPassword())
                .email(registerDto.getEmail())
                .address(registerDto.getAddress())
                .phone(registerDto.getPhone())
                .gender(registerDto.getGender())
                .birthday(registerDto.getBirthday())
                .role(registerDto.getRole() != null ? registerDto.getRole() : UserRole.user)
                .build();

        userRepository.save(user);
        return "User registered successfully!";
    }

    @Override
    public String resetPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return "Password reset successful!";
        }
        return "Email not found!";
    }

    @Override
    public void logout() {

    }
}
