package com.example.SB_Week9.dto;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.Nationalized;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreeningRoomDto {
    private String roomName;

    private Long cinemaID;
}
