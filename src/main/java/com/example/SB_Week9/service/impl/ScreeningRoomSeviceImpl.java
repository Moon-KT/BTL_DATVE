package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.ScreeningRoomDto;
import com.example.SB_Week9.entity.ScreeningRoom;
import com.example.SB_Week9.repository.CinemaRepository;
import com.example.SB_Week9.repository.ScreeningRoomRepository;
import com.example.SB_Week9.service.ScreeningRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreeningRoomSeviceImpl implements ScreeningRoomService {

    @Autowired
    private ScreeningRoomRepository screeningRoomRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    private ScreeningRoomDto convertToDto(ScreeningRoom screeningRoom) {
        return ScreeningRoomDto.builder()
                .roomName(screeningRoom.getRoomName())
                .cinemaID(screeningRoom.getCinema().getCinemaID())
                .build();
    }
    @Override
    public ScreeningRoomDto create(ScreeningRoomDto screeningRoomDto) throws Exception {
        return convertToDto(screeningRoomRepository.save(ScreeningRoom.builder()
                .roomName(screeningRoomDto.getRoomName())
                .cinema(cinemaRepository.findById(screeningRoomDto.getCinemaID()).orElseThrow(() -> {
                    return new Exception("Không tìm thấy rạp chiếu phim có ID: " + screeningRoomDto.getCinemaID());
                }))
                .build()));
    }

    @Override
    public List<ScreeningRoomDto> reads() {
        return screeningRoomRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public ScreeningRoomDto read(Long screeningRoomID) throws Exception {
        return screeningRoomRepository.findById(screeningRoomID)
                .map(this::convertToDto)
                .orElseThrow(() -> { return new Exception("Không tìm thấy phòng chiếu có ID: " + screeningRoomID);});
    }

    @Override
    public ScreeningRoomDto update(Long screeningRoomID, ScreeningRoomDto screeningRoomDto) throws Exception {
        ScreeningRoom screeningRoom = screeningRoomRepository.findById(screeningRoomID)
                .orElseThrow(() -> { return new Exception("Không tìm thấy phòng chiếu có ID: " + screeningRoomID);});
        screeningRoom.setRoomName(screeningRoomDto.getRoomName());
        screeningRoom.setCinema(cinemaRepository.findById(screeningRoomDto.getCinemaID()).orElseThrow(() -> {
            return new Exception("Không tìm thấy rạp chiếu phim có ID: " + screeningRoomDto.getCinemaID());
        }));
        return convertToDto(screeningRoomRepository.save(screeningRoom));
    }

    @Override
    public void delete(Long screeningRoomID) throws Exception {
        if(!screeningRoomRepository.existsById(screeningRoomID)) {
            throw new Exception("Không tìm thấy phòng chiếu có ID: " + screeningRoomID);
        }
        screeningRoomRepository.deleteById(screeningRoomID);
    }
}
