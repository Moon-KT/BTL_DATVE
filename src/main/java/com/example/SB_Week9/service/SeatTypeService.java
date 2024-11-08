package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.SeatTypeDto;
import com.example.SB_Week9.entity.SeatType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeatTypeService {
    //CRUD
    SeatTypeDto create(SeatTypeDto seatTypeDto) throws Exception;
    List<SeatTypeDto> reads();
    SeatTypeDto read(Long seatTypeId) throws Exception;
    SeatTypeDto update(Long seatTypeId, SeatTypeDto seatTypeDto) throws Exception;
    void delete(Long seatTypeId) throws Exception;
}
