package com.example.SB_Week9.dto;

import com.example.SB_Week9.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookingRequest {
    private Showtime showtime;
    private User user;
    private List<Seat> seats;
    private Promotion promotion;
}
