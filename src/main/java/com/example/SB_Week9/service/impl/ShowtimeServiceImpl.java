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

    @Override
    public List<Showtime> reads() {
        return showtimeRepository.findAll();
    }

    @Override
    public Showtime read(Long showtimeID) throws Exception {
        Optional<Showtime> showtime = Optional.ofNullable(showtimeRepository.findById(showtimeID))
                .orElseThrow(() -> {
                    return new Exception("Không tìm thấy suất chiếu có ID: " + showtimeID);
                });

        return showtime.get();
    }

    @Override
    public Showtime create(ShowtimeDto showtimeDto) throws Exception {
        Optional<Movie> movie = Optional.ofNullable(movieRepository.findById(showtimeDto.getMovieID())
                .orElseThrow(() -> new Exception("Không tìm thấy phim có ID: " + showtimeDto.getMovieID())));
        Optional<ScreeningRoom> screeningRoom = Optional.ofNullable(screeningRoomRepository.findById(showtimeDto.getRoomID())
                .orElseThrow(() -> new Exception("Không tìm thấy phòng chiếu có ID: " + showtimeDto.getRoomID())));

        Showtime showtime = new Showtime();
        showtime.setStartTime(showtimeDto.getStartTime());
        showtime.setMovie(movie.get());
        showtime.setRoom(screeningRoom.get());
        return showtimeRepository.save(showtime);
    }

    @Override
    public Showtime update(Long showtimeID, ShowtimeDto showtimeDto) throws Exception {
        Optional<Movie> movie = Optional.ofNullable(movieRepository.findById(showtimeDto.getMovieID())
                .orElseThrow(() -> new Exception("Không tìm thấy phim có ID: " + showtimeDto.getMovieID())));
        Optional<ScreeningRoom> screeningRoom = Optional.ofNullable(screeningRoomRepository.findById(showtimeDto.getRoomID())
                .orElseThrow(() -> new Exception("Không tìm thấy phòng chiếu có ID: " + showtimeDto.getRoomID())));

        Optional<Showtime> showtime = Optional.ofNullable(showtimeRepository.findById(showtimeID))
                .orElseThrow(() -> {
                    return new Exception("Không tìm thấy suất chiếu có ID: " + showtimeID);
                });

        showtime.get().setStartTime(showtimeDto.getStartTime());
        showtime.get().setMovie(movie.get());
        showtime.get().setRoom(screeningRoom.get());

        return showtime.get();
    }

    @Override
    public void delete(Long showtimeID) throws Exception {
        Optional<Showtime> showtime = Optional.ofNullable(showtimeRepository.findById(showtimeID))
                .orElseThrow(() -> {
                    return new Exception("Không tìm thấy suất chiếu có ID: " + showtimeID);
                });

        showtimeRepository.delete(showtime.get());
    }
}
