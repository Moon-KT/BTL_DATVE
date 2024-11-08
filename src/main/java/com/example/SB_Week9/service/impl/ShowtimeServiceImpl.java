package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.ShowtimeDto;
import com.example.SB_Week9.entity.Movie;
import com.example.SB_Week9.entity.ScreeningRoom;
import com.example.SB_Week9.entity.Showtime;
import com.example.SB_Week9.repository.MovieRepository;
import com.example.SB_Week9.repository.ScreeningRoomRepository;
import com.example.SB_Week9.repository.ShowtimeRepository;
import com.example.SB_Week9.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {
    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private ScreeningRoomRepository screeningRoomRepository;

    @Autowired
    private MovieRepository movieRepository;

    private ShowtimeDto convertToDto(Showtime showtime) {
        return ShowtimeDto.builder()
                .startTime(showtime.getStartTime())
                .movieID(showtime.getMovie().getMovieID())
                .roomID(showtime.getRoom().getRoomID())
                .build();
    }

    @Override
    public List<ShowtimeDto> reads() {
        return showtimeRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public ShowtimeDto read(Long showtimeID) throws Exception {
        return showtimeRepository.findById(showtimeID)
                .map(this::convertToDto)
                .orElseThrow(() -> new Exception("Không tìm thấy suất chiếu có ID: " + showtimeID));
    }

    @Override
    public ShowtimeDto create(ShowtimeDto showtimeDto) throws Exception {
        Optional<Movie> movie = Optional.ofNullable(movieRepository.findById(showtimeDto.getMovieID())
                .orElseThrow(() -> new Exception("Không tìm thấy phim có ID: " + showtimeDto.getMovieID())));
        Optional<ScreeningRoom> screeningRoom = Optional.ofNullable(screeningRoomRepository.findById(showtimeDto.getRoomID())
                .orElseThrow(() -> new Exception("Không tìm thấy phòng chiếu có ID: " + showtimeDto.getRoomID())));

        return convertToDto(showtimeRepository.save(Showtime.builder()
                .startTime(showtimeDto.getStartTime())
                .movie(movie.get())
                .room(screeningRoom.get())
                .build()));
    }

    @Override
    public ShowtimeDto update(Long showtimeID, ShowtimeDto showtimeDto) throws Exception {
        Optional<Movie> movie = Optional.ofNullable(movieRepository.findById(showtimeDto.getMovieID())
                .orElseThrow(() -> new Exception("Không tìm thấy phim có ID: " + showtimeDto.getMovieID())));
        Optional<ScreeningRoom> screeningRoom = Optional.ofNullable(screeningRoomRepository.findById(showtimeDto.getRoomID())
                .orElseThrow(() -> new Exception("Không tìm thấy phòng chiếu có ID: " + showtimeDto.getRoomID())));

        Showtime showtime = showtimeRepository.findById(showtimeID).orElseThrow(() -> new Exception("Không tìm thấy suất chiếu có ID: " + showtimeID));

        return convertToDto(showtimeRepository.save(showtime.toBuilder()
                .startTime(showtimeDto.getStartTime())
                .movie(movie.get())
                .room(screeningRoom.get())
                .build()));
    }

    @Override
    public void delete(Long showtimeID) throws Exception {
        if(!showtimeRepository.existsById(showtimeID)) {
            throw new Exception("Không tìm thấy suất chiếu có ID: " + showtimeID);
        }
        showtimeRepository.deleteById(showtimeID);
    }
}
