package com.example.SB_Week9.dto;

import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatTypeDto {
    private String seatTypeName;
    private Double seatPrice;
    private List<SeatDto> seatList;
}
