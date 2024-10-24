package com.example.SB_Week9.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDto {
    @Nationalized
    private String movieName;

    @Nationalized
    @Column(length = 1000)
    private String movieDescription;

    @Nationalized
    private String movieDirector;

    @Nationalized
    private String movieActor;

    private Integer movieDuration;
    private LocalDateTime movieReleaseDate;
    private String moviePoster;

    @Nationalized
    private String movieLanguage;
}
