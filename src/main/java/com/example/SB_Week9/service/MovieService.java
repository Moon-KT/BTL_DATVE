package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.MovieDto;
import com.example.SB_Week9.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    //CRUD
    MovieDto create(MovieDto movieDto) throws Exception;
    List<MovieDto> reads();
    MovieDto read(Long movieID) throws Exception;
    MovieDto update(Long movieID, MovieDto movieDto) throws Exception;
    void delete(Long movieID) throws Exception;

    //Other
    List<MovieDto> search(String keyword);
}
