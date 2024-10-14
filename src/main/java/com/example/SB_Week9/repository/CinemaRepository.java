package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {
    //List<Cinema> findCinemasByTheaterId(Long theaterId);
}
