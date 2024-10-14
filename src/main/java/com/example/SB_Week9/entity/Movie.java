package com.example.SB_Week9.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieID;
    private String movieName;
    private String movieDescription;
    private String movieDirector;
    private String movieActor;
    private String movieDuration;
    private String movieReleaseDate;
    private String moviePoster;
    private String movieLanguage;

    @OneToMany(mappedBy = "movie")
    private Set<Showtime> showtimes;

    @ManyToMany
    @JoinTable(
        name = "movie_genres",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

}
