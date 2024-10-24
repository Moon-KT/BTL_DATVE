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

    @Override
    public ScreeningRoom create(ScreeningRoomDto screeningRoomDto) throws Exception {
        ScreeningRoom screeningRoom = new ScreeningRoom();
        screeningRoom.setRoomName(screeningRoomDto.getRoomName());
        return screeningRoomRepository.save(screeningRoom);
    }

    @Override
    public List<ScreeningRoom> reads() {
        return screeningRoomRepository.findAll();
    }

    @Override
    public ScreeningRoom read(Long screeningRoomID) throws Exception {
        Optional<ScreeningRoom> screeningRoom = Optional.ofNullable(screeningRoomRepository.findById(screeningRoomID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy phòng chiếu có ID: " + screeningRoomID);});
        return screeningRoom.get();
    }

    @Override
    public ScreeningRoom update(Long screeningRoomID, ScreeningRoomDto screeningRoomDto) throws Exception {
        Optional<ScreeningRoom> screeningRoom = Optional.ofNullable( screeningRoomRepository.findById(screeningRoomID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy phòng chiếu có ID: " + screeningRoomID);});

        screeningRoom.get().setRoomName(screeningRoomDto.getRoomName());
        return screeningRoomRepository.save(screeningRoom.get());
    }

    @Override
    public void delete(Long screeningRoomID) throws Exception {
        Optional<ScreeningRoom> screeningRoom = Optional.ofNullable(screeningRoomRepository.findById(screeningRoomID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy phòng chiếu có ID: " + screeningRoomID);});
        screeningRoomRepository.delete(screeningRoom.get());
    }
}
