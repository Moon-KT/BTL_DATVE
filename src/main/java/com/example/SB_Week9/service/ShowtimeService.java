package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.ShowtimeDto;
import com.example.SB_Week9.entity.Showtime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowtimeService {
    //CRUD
    ShowtimeDto create(ShowtimeDto showtimeDto) throws Exception;
    ShowtimeDto read(Long showtimeID) throws Exception;
    List<ShowtimeDto> reads();
    ShowtimeDto update(Long showtimeID, ShowtimeDto showtimeDto) throws Exception;
    void delete(Long showtimeID) throws Exception;

}
