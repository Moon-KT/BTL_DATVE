package com.example.SB_Week9.dto;

import com.example.SB_Week9.entity.enumModel.SeatStatus;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.Nationalized;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatDto {
    private String seatRow;
    private Integer seatNumber;
    private SeatStatus status;

    private Long seatTypeID;
}
