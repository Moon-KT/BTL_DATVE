package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.SeatDto;
import com.example.SB_Week9.entity.Seat;
import com.example.SB_Week9.entity.SeatType;
import com.example.SB_Week9.entity.Showtime;
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
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private SeatTypeRepository seatTypeRepository;

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Seat getSeatById(Long seatId) throws Exception {
        return seatRepository.getSeatByID(seatId)
                .orElseThrow(() -> new Exception("Không tìm thấy ghế có ID: " + seatId));
    }

    @Override
    public Seat create(SeatDto seatDto) throws Exception {
        Optional<Showtime> showtime = Optional.ofNullable(showtimeRepository.findById(seatDto.getShowtimeID())
                .orElseThrow(() -> { return new Exception("Không tìm thấy suất chiếu có ID: " + seatDto.getShowtimeID());}));
        Optional<SeatType> seatType = Optional.ofNullable(seatTypeRepository.findById(seatDto.getSeatTypeID())
                .orElseThrow(() -> { return new Exception("Không tìm thấy loại ghế có ID: " + seatDto.getSeatTypeID());}));

        Seat seat = new Seat();
        seat.setSeatNumber(seatDto.getSeatNumber());
        seat.setStatus(seatDto.getStatus());
        seat.setShowtime(showtime.get());
        seat.setSeatType(seatType.get());
        return seatRepository.save(seat);
    }

    @Override
    public Seat update(Long seatId, SeatDto seatDto) throws Exception {
        return null;
    }

    @Override
    public void delete(Long seatId) throws Exception {

    }
}
