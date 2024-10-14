package com.example.SB_Week9.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String username;

    private String email;
    private String phone;
    private String address;
    private String gender;
    private String birthday;
    private String role;
}
