package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {
    List<Showtime> findByMovieId(Long movieId);
}
