package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.SeatTypeDto;
import com.example.SB_Week9.entity.SeatType;
import com.example.SB_Week9.repository.SeatTypeRepository;
import com.example.SB_Week9.service.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatTypeServiceImpl implements SeatTypeService {
    @Autowired
    private SeatTypeRepository seatTypeRepository;

    @Override
    public List<SeatType> getAllSeatTypes() throws Exception {
        return seatTypeRepository.findAll();
    }

    @Override
    public SeatType getSeatTypeById(Long seatTypeId) throws Exception {
        return seatTypeRepository.findById(seatTypeId)
                .orElseThrow(() -> { return new Exception("Không tìm thấy loại ghế có ID: " + seatTypeId);
                });
    }

    @Override
    public SeatType create(SeatTypeDto seatTypeDto) throws Exception {
        SeatType seatType = new SeatType();
        seatType.setSeatTypeName(seatTypeDto.getSeatTypeName());
        return seatTypeRepository.save(seatType);
    }

    @Override
    public SeatType update(Long seatTypeId, SeatTypeDto seatTypeDto) throws Exception {
        Optional<SeatType> seatType = Optional.ofNullable(seatTypeRepository.findById(seatTypeId))
                .orElseThrow(() -> { return new Exception("Không tìm thấy loại ghế có ID: " + seatTypeId);
                });
        seatType.get().setSeatTypeName(seatTypeDto.getSeatTypeName());

        return seatType.get();
    }

    @Override
    public void delete(Long seatTypeId) throws Exception {
        Optional<SeatType> seatType = Optional.ofNullable(seatTypeRepository.findById(seatTypeId))
                .orElseThrow(() -> { return new Exception("Không tìm thấy loại ghế có ID: " + seatTypeId);
                });
        seatTypeRepository.delete(seatType.get());
    }
}
