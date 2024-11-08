package com.example.SB_Week9.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "movie_id")
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime movieReleaseDate;

    private String moviePoster;

    @Nationalized
    private String movieLanguage;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Showtime> showtimeList;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Movie_Genre> movie_genreList;
}
