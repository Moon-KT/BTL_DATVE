package com.example.SB_Week9.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long genreID;
    private String genreName;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies;
}
