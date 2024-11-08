package com.example.SB_Week9.entity;

import com.example.SB_Week9.entity.key.MovieGenreKey;
import jakarta.persistence.*;

@Entity
@Table(name = "movie_genre", uniqueConstraints = {@UniqueConstraint(columnNames = {"movie_id", "genre_id"})})
public class Movie_Genre {
    @EmbeddedId
    private MovieGenreKey id;

    @ManyToOne
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "genre_id", insertable = false, updatable = false)
    private Genre genre;

}
