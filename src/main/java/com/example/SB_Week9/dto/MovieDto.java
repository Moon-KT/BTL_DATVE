package com.example.SB_Week9.dto;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDto {
    private Long movieID;
    private String movieName;
    private String movieDescription;
    private String movieDirector;
    private String movieActor;
    private String movieDuration;
    private String movieReleaseDate;
    private String moviePoster;
    private String movieTrailer;
    private String movieRating;
    private String movieStatus;
    private String movieLanguage;
}
