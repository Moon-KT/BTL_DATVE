package com.example.SB_Week9.controller;

import com.example.SB_Week9.dto.LoginDto;
import com.example.SB_Week9.dto.RegisterDto;
import com.example.SB_Week9.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class MainController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDTO) {
        String result = authService.register(registerDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDTO) {
        String result = authService.login(loginDTO.getEmail(), loginDTO.getPassword());
        return result.equals("Login successful!") ?
                ResponseEntity.ok(result) :
                ResponseEntity.status(401).body(result);
    }

    @PostMapping("/forget-password")
    public ResponseEntity<String> forgetPassword(@RequestParam String email, @RequestParam String newPassword) {
        String result = authService.resetPassword(email, newPassword);
        return ResponseEntity.ok(result);
    }
}
