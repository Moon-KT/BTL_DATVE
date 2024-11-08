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

    private SeatTypeDto convertToDto(SeatType seatType) {
        return SeatTypeDto.builder()
                .seatTypeName(seatType.getSeatTypeName())
                .seatPrice(seatType.getSeatPrice())
                .build();
    }
    @Override
    public SeatTypeDto create(SeatTypeDto seatTypeDto) throws Exception {
        SeatType seatType = SeatType.builder()
                .seatTypeName(seatTypeDto.getSeatTypeName())
                .seatPrice(seatTypeDto.getSeatPrice())
                .build();
        return convertToDto(seatTypeRepository.save(seatType));
    }

    @Override
    public List<SeatTypeDto> reads(){
        return seatTypeRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public SeatTypeDto read(Long seatTypeId) throws Exception {
        return seatTypeRepository.findById(seatTypeId)
                .map(this::convertToDto)
                .orElseThrow(() -> new Exception("Không tìm thấy loại ghế có ID: " + seatTypeId));
    }

    @Override
    public SeatTypeDto update(Long seatTypeId, SeatTypeDto seatTypeDto) throws Exception {
        SeatType seatType = seatTypeRepository.findById(seatTypeId)
                .orElseThrow(() -> new Exception("Không tìm thấy loại ghế có ID: " + seatTypeId));
        seatType.toBuilder()
                .seatTypeName(seatTypeDto.getSeatTypeName())
                .seatPrice(seatTypeDto.getSeatPrice())
                .build();
        return convertToDto(seatTypeRepository.save(seatType));
    }

    @Override
    public void delete(Long seatTypeId) throws Exception {
        if(!seatTypeRepository.existsById(seatTypeId)){
            throw new Exception("Không tìm thấy loại ghế có ID: " + seatTypeId);
        }
        seatTypeRepository.deleteById(seatTypeId);
    }
}
