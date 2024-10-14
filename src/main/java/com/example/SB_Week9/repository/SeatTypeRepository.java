package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatTypeRepository extends JpaRepository<SeatType,Long> {
    List<SeatType> findSeatTypesByRoomId(Long roomId);
}
