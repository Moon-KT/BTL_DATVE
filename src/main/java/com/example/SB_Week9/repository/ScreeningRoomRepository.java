package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.ScreeningRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreeningRoomRepository extends JpaRepository<ScreeningRoom,Long> {
    List<ScreeningRoom> findScreeningRoomsByCinemaId(Long cinemaId);
}
