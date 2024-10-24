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

    @Autowired
    private ScreeningRoomRepository screeningRoomRepository;

    @Override
    public Seat create(SeatDto seatDto) throws Exception {
        Optional<SeatType> seatType = Optional.ofNullable(seatTypeRepository.findById(seatDto.getSeatTypeID())
                .orElseThrow(() -> { return new Exception("Không tìm thấy loại ghế có ID: " + seatDto.getSeatTypeID());}));

        Seat seat = new Seat();
        seat.setSeatNumber(seatDto.getSeatNumber());
        seat.setStatus(seatDto.getStatus());
        seat.setSeatType(seatType.get());
        seat.setScreeningRoom(screeningRoomRepository.findById(seatDto.getSeatTypeID()).get());
        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> reads() {
        return seatRepository.findAll();
    }

    @Override
    public Seat read(Long seatId) throws Exception {
        Optional<Seat> seat = seatRepository.findById(seatId);
        if (seat.isEmpty()) {
            throw new Exception("Không tìm thấy ghế có ID: " + seatId);
        }
        return seat.get();
    }

    @Override
    public Seat update(Long seatId, SeatDto seatDto) throws Exception {
        Optional<Seat> seat = seatRepository.findById(seatId);
        if (seat.isEmpty()) {
            throw new Exception("Không tìm thấy ghế có ID: " + seatId);
        }

        Optional<SeatType> seatType = Optional.ofNullable(seatTypeRepository.findById(seatDto.getSeatTypeID())
                .orElseThrow(() -> { return new Exception("Không tìm thấy loại ghế có ID: " + seatDto.getSeatTypeID());}));

        seat.get().setSeatNumber(seatDto.getSeatNumber());
        seat.get().setStatus(seatDto.getStatus());
        seat.get().setSeatType(seatType.get());
        seat.get().setScreeningRoom(screeningRoomRepository.findById(seatDto.getSeatTypeID()).get());
        return seatRepository.save(seat.get());
    }

    @Override
    public void delete(Long seatId) throws Exception {
        Optional<Seat> seat = seatRepository.findById(seatId);
        if (seat.isEmpty()) {
            throw new Exception("Không tìm thấy ghế có ID: " + seatId);
        }
        seatRepository.delete(seat.get());
    }
}
