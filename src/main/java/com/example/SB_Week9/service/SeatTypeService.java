package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.SeatTypeDto;
import com.example.SB_Week9.entity.SeatType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeatTypeService {
    SeatType create(SeatTypeDto seatTypeDto) throws Exception;
    List<SeatType> reads();
    SeatType read(Long seatTypeId) throws Exception;
    SeatType update(Long seatTypeId, SeatTypeDto seatTypeDto) throws Exception;
    void delete(Long seatTypeId) throws Exception;
}
