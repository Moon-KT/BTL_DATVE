package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.SeatTypeDto;
import com.example.SB_Week9.entity.SeatType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeatTypeService {
    List<SeatType> getAllSeatTypes() throws Exception;
    SeatType getSeatTypeById(Long seatTypeId) throws Exception;
    SeatType create(SeatTypeDto seatTypeDto) throws Exception;
    SeatType update(Long seatTypeId, SeatTypeDto seatTypeDto) throws Exception;
    void delete(Long seatTypeId) throws Exception;
}
