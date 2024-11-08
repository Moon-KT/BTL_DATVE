package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.SeatDto;
import com.example.SB_Week9.entity.Seat;
import com.example.SB_Week9.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SeatService {
   //CRUD
   SeatDto create(SeatDto seatDto) throws Exception;
   List<SeatDto> reads();
   SeatDto read(Long seatId) throws Exception;
   SeatDto update(Long seatId, SeatDto seatDto) throws Exception;
   void delete(Long seatId) throws Exception;
}
