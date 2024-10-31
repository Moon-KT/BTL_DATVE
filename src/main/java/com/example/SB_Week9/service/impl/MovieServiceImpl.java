package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.MovieDto;
import com.example.SB_Week9.entity.Movie;
import com.example.SB_Week9.entity.ScreeningRoom;
import com.example.SB_Week9.repository.MovieRepository;
import com.example.SB_Week9.repository.ScreeningRoomRepository;
import com.example.SB_Week9.repository.ShowtimeRepository;
import com.example.SB_Week9.service.MovieService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ScreeningRoomRepository screeningRoomRepository;
    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Override
    public Movie create(MovieDto movieDto) throws Exception {
        Movie movie = new Movie();

        movie.setMovieName(movieDto.getMovieName());
        movie.setMovieDescription(movieDto.getMovieDescription());
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> reads() {
        return movieRepository.findAll();
    }

    @Override
    public Movie read(Long movieID) throws Exception {
        Optional<Movie> movie = Optional.ofNullable(movieRepository.findById(movieID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy phim có ID: " + movieID);
                });
        return movie.get();
    }

    @Override
    public Movie update(Long movieID, MovieDto movieDto) throws Exception {
        Optional<Movie> movie = Optional.ofNullable(movieRepository.findById(movieID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy phim có ID: " + movieID);
                });
        movie.get().setMovieName(movieDto.getMovieName());
        movie.get().setMovieDescription(movieDto.getMovieDescription());
        return movie.get();
    }

    @Override
    public void delete(Long movieID) throws Exception {
        Optional<Movie> movie = Optional.ofNullable(movieRepository.findById(movieID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy phim có ID: " + movieID);
                });
        movieRepository.delete(movie.get());
    }
}
