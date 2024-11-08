package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.CinemaDto;
import com.example.SB_Week9.dto.MovieDto;
import com.example.SB_Week9.dto.ScreeningRoomDto;
import com.example.SB_Week9.dto.UserDto;
import com.example.SB_Week9.entity.Cinema;
import com.example.SB_Week9.entity.User;
import com.example.SB_Week9.repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CinemaService {
    //CRUD
    CinemaDto create(CinemaDto cinemaDto) throws Exception;
    List<CinemaDto> reads();
    CinemaDto read(Long cinemaID) throws Exception;
    CinemaDto update(Long cinemaID, CinemaDto cinemaDto) throws Exception;
    void delete(Long cinemaID) throws Exception;

    //Other
    List<ScreeningRoomDto> getRoomByCinema(Long cinemaID);
    List<MovieDto> getMovieByCinema(Long cinemaID);
}
