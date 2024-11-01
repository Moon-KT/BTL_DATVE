package com.example.SB_Week9.dto;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class SeatDto {
    private String seatRow;
    private int seatNumber;
    private String status;

    private Long showtimeID;
    private Long seatTypeID;
}
