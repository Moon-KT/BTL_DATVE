package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie,Long> {
}
