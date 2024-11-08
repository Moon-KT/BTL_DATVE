package com.example.SB_Week9.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResponse {
    private Long bookingID;
    private Double finalPrice;
    private String message;
}
