package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Seat> findSeatsByRoomId(Long roomId);
    Optional<Seat> getSeatByID(Long seatId);
}
