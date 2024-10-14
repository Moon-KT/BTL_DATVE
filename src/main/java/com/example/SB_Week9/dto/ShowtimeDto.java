package com.example.SB_Week9.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowtimeDto {
    private LocalDateTime startTime;

    private Long ScreeningID;
    private Long movieID;
}
