package com.example.SB_Week9.dto;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CinemaDto {
    @Nationalized
    private String cinemaName;
    private String hotline;
    @Nationalized
    private String detailedAddress;

    private Long locationID;
}
