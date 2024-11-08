package com.example.SB_Week9.dto;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.Nationalized;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CinemaDto {
    private String cinemaName;
    private String hotline;
    private String detailedAddress;

    private Long locationID;
}
