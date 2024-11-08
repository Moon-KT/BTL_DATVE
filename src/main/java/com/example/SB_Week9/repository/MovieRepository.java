package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query("SELECT m FROM Movie m WHERE m.movieName LIKE %:keyword% OR m.movieDescription LIKE %:keyword%")
    List<Movie> searchByKeyword(String keyword);
}
