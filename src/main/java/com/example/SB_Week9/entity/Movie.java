package com.example.SB_Week9.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.List;
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

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Showtime> showtimes;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Movie_Genre> movie_genreList;


}
