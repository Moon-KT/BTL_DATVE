package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.ScreeningRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ScreeningRoomRepository extends JpaRepository<ScreeningRoom,Long> {
}
