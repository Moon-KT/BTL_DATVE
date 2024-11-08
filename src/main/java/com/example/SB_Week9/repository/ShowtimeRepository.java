package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    @Query("SELECT s FROM Showtime s " +
            "JOIN Movie m ON m.movieID = s.movie.movieID " +
            "JOIN ScreeningRoom r ON r.roomID = s.room.roomID " +
            "JOIN Cinema c ON c.cinemaID = r.cinema.cinemaID " +
            "WHERE m.movieName = :movieName " +
            "AND c.cinemaName = :cinemaName")
    Showtime findByMovieNameAndCinemaName(@Param("movieName") String movieName,
                                        @Param("cinemaName") String cinemaName);
}