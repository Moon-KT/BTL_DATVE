package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.ScreeningRoomDto;
import com.example.SB_Week9.entity.ScreeningRoom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScreeningRoomService {
    ScreeningRoom create(ScreeningRoomDto screeningRoomDto) throws Exception;
    List<ScreeningRoom> reads();
    ScreeningRoom read(Long screeningRoomID) throws Exception;
    ScreeningRoom update(Long screeningRoomID, ScreeningRoomDto screeningRoomDto) throws Exception;
    void delete(Long screeningRoomID) throws Exception;
}
