package com.example.SB_Week9.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_genre")
public class Movie_Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

}
