package com.example.SB_Week9.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowtimeDto {
    private LocalDateTime startTime;
    private Long roomID;
    private Long movieID;
}
