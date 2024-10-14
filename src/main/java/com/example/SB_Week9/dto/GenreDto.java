package com.example.SB_Week9.dto;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenreDto {
    private Long genreID;
    private String genreName;
}
