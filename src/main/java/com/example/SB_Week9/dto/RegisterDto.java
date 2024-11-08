package com.example.SB_Week9.dto;

import com.example.SB_Week9.entity.enumModel.Gender;
import com.example.SB_Week9.entity.enumModel.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDto {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private LocalDate birthday;
    private Gender gender;
    private UserRole role;
}
