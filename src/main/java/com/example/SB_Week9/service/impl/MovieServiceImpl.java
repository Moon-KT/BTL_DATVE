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
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    private MovieDto convertToDto(Movie movie) {
        return MovieDto.builder()
                .movieName(movie.getMovieName())
                .movieDescription(movie.getMovieDescription())
                .movieActor(movie.getMovieActor())
                .movieDirector(movie.getMovieDirector())
                .movieDuration(movie.getMovieDuration())
                .movieLanguage(movie.getMovieLanguage())
                .moviePoster(movie.getMoviePoster())
                .movieReleaseDate(movie.getMovieReleaseDate())
                .build();
    }
    @Override
    public MovieDto create(MovieDto movieDto) throws Exception {
        Movie movie = Movie.builder()
                .movieName(movieDto.getMovieName())
                .movieDescription(movieDto.getMovieDescription())
                .movieActor(movieDto.getMovieActor())
                .movieDirector(movieDto.getMovieDirector())
                .movieDuration(movieDto.getMovieDuration())
                .movieLanguage(movieDto.getMovieLanguage())
                .moviePoster(movieDto.getMoviePoster())
                .movieReleaseDate(movieDto.getMovieReleaseDate())
                .build();
        return convertToDto(movieRepository.save(movie));
    }

    @Override
    public List<MovieDto> reads() {
        return movieRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public MovieDto read(Long movieID) throws Exception {
        return movieRepository.findById(movieID)
                .map(this::convertToDto)
                .orElseThrow(() -> new Exception("Không tìm thấy phim có ID: " + movieID));
    }

    @Override
    public MovieDto update(Long movieID, MovieDto movieDto) throws Exception {
        Movie existingMovie = movieRepository.findById(movieID)
                .orElseThrow(() -> new Exception("Không tìm thấy phim có ID: " + movieID));
        Movie updatedMovie = existingMovie.toBuilder()
                .movieName(movieDto.getMovieName())
                .movieDescription(movieDto.getMovieDescription())
                .movieActor(movieDto.getMovieActor())
                .movieDirector(movieDto.getMovieDirector())
                .movieDuration(movieDto.getMovieDuration())
                .movieLanguage(movieDto.getMovieLanguage())
                .moviePoster(movieDto.getMoviePoster())
                .movieReleaseDate(movieDto.getMovieReleaseDate())
                .build();
        return convertToDto(movieRepository.save(updatedMovie));
    }

    @Override
    public void delete(Long movieID) throws Exception {
        if(!movieRepository.existsById(movieID)) {
            throw new Exception("Không tìm thấy phim có ID: " + movieID);
        }
        movieRepository.deleteById(movieID);
    }

    @Override
    public List<MovieDto> search(String keyword) {
        List<Movie> movies = movieRepository.searchByKeyword(keyword);
        return movies.stream().map(movie -> {
            MovieDto movieDto = new MovieDto();
            movieDto.setMovieName(movie.getMovieName());
            movieDto.setMovieDescription(movie.getMovieDescription());
            return movieDto;
        }).collect(Collectors.toList());
    }
}
