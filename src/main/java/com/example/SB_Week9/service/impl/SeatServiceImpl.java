package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.SeatDto;
import com.example.SB_Week9.entity.Seat;
import com.example.SB_Week9.entity.SeatType;
import com.example.SB_Week9.entity.Showtime;
import com.example.SB_Week9.repository.ScreeningRoomRepository;
import com.example.SB_Week9.repository.SeatRepository;
import com.example.SB_Week9.repository.SeatTypeRepository;
import com.example.SB_Week9.repository.ShowtimeRepository;
import com.example.SB_Week9.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatTypeRepository seatTypeRepository;

    private SeatDto convertToDto(Seat seat) {
        return SeatDto.builder()
                .seatNumber(seat.getSeatNumber())
                .seatRow(seat.getSeatRow())
                .status(seat.getStatus())
                .seatTypeID(seat.getSeatType().getSeatTypeID())
                .build();
    }
    @Override
    public SeatDto create(SeatDto seatDto) throws Exception {
        Seat seat = Seat.builder()
                .seatNumber(seatDto.getSeatNumber())
                .seatRow(seatDto.getSeatRow())
                .status(seatDto.getStatus())
                .seatType(seatTypeRepository.findById(seatDto.getSeatTypeID()).get())
                .build();
        return convertToDto(seatRepository.save(seat));
    }

    @Override
    public List<SeatDto> reads() {
        return seatRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public SeatDto read(Long seatId) throws Exception {
        return seatRepository.findById(seatId)
                .map(this::convertToDto)
                .orElseThrow(() -> new Exception("Không tìm thấy ghế có ID: " + seatId));
    }

    @Override
    public SeatDto update(Long seatId, SeatDto seatDto) throws Exception {
        Seat seat = seatRepository.findById(seatId).orElseThrow(() -> new Exception("Không tìm thấy ghế có ID: " + seatId));

        return convertToDto(seatRepository.save(seat.toBuilder()
                        .seatNumber(seatDto.getSeatNumber())
                        .seatRow(seatDto.getSeatRow())
                        .status(seatDto.getStatus())
                        .seatType(seatTypeRepository.findById(seatDto.getSeatTypeID()).get())
                .build()));
    }

    @Override
    public void delete(Long seatId) throws Exception {
        Seat seat = seatRepository.findById(seatId).orElseThrow(() -> new Exception("Không tìm thấy ghế có ID: " + seatId));
        seatRepository.delete(seat);
    }
}
