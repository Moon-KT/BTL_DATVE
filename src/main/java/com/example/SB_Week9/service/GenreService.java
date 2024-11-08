package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.GenreDto;
import com.example.SB_Week9.entity.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService {
    //CRUD
    GenreDto create(GenreDto genreDto) throws Exception;
    List<GenreDto> reads();
    GenreDto read(Long genreID) throws Exception;
    GenreDto update(Long genreID, GenreDto genreDto) throws Exception;
    void delete(Long genreID) throws Exception;

    //Other
}
