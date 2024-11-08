package com.example.SB_Week9.dto;

import com.example.SB_Week9.entity.enumModel.Gender;
import com.example.SB_Week9.entity.enumModel.UserRole;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class UserDto {
    private String username;
    private String email;
    private String password;
    private String phone;
    private LocalDate birthday;
    private Gender gender;
    private String address;
    private UserRole role;
    private Double totalSpent;
    private LocalDateTime createdAt;
    private Boolean enabled;
    private List<BookingRequest> bookingRequests;
}
