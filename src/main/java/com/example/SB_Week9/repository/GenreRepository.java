package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    //List<Genre> findGenresByMovieId(Long movieId);
}