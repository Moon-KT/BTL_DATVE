package com.example.SB_Week9.entity.key;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@Embeddable
@EqualsAndHashCode
public class MovieGenreKey {
    private Long movieID;
    private Long genreID;
}
