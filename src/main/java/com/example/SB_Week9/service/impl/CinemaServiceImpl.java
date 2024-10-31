package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.CinemaDto;
import com.example.SB_Week9.dto.MovieDto;
import com.example.SB_Week9.dto.ScreeningRoomDto;
import com.example.SB_Week9.entity.Cinema;
import com.example.SB_Week9.entity.Location;
import com.example.SB_Week9.repository.CinemaRepository;
import com.example.SB_Week9.repository.LocationRepository;
import com.example.SB_Week9.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Cinema create(CinemaDto cinemaDto) throws Exception {
        Optional<Location> location = Optional.ofNullable(locationRepository.findById(cinemaDto.getLocationID())
                .orElseThrow(() -> {
                    return new Exception("Không tìm thấy địa điểm có ID: " + cinemaDto.getLocationID());
                }));
        Cinema cinema = new Cinema();
        cinema.setCinemaName(cinemaDto.getCinemaName());

        cinema.setLocation(location.get());

        return cinemaRepository.save(cinema);
    }

    @Override
    public List<Cinema> reads() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema read(Long cinemaID) throws Exception {
        Optional<Cinema> cinema = Optional.ofNullable(cinemaRepository.findById(cinemaID))
                .orElseThrow(() -> {
                    return new Exception("Không tìm thấy rạp có ID: " + cinemaID);
                });
        return cinema.get();
    }

    @Override
    public Cinema update(Long cinemaID, CinemaDto cinemaDto) throws Exception {
        Optional<Cinema> cinema = Optional.ofNullable(cinemaRepository.findById(cinemaID))
                .orElseThrow(() -> {
                    return new Exception("Không tìm thấy rạp có ID: " + cinemaID);
                });
        Optional<Location> location = Optional.ofNullable(locationRepository.findById(cinemaDto.getLocationID())
                .orElseThrow(() -> {
                    return new Exception("Không tìm thấy địa điểm có ID: " + cinemaDto.getLocationID());
                }));
        cinema.get().setCinemaName(cinemaDto.getCinemaName());
        cinema.get().setLocation(location.get());
        return cinema.get();
    }

    @Override
    public void delete(Long userID) throws Exception {
        Optional<Cinema> cinema = Optional.ofNullable(cinemaRepository.findById(userID))
                .orElseThrow(() -> {
                    return new Exception("Không tìm thấy rạp có ID: " + userID);
                });
        cinemaRepository.delete(cinema.get());
    }

    @Override
    public List<ScreeningRoomDto> getRoomByCinema(Long cinemaID) {
        return cinemaRepository.findById(cinemaID)
                .map(cinema -> cinema.getScreeningRoomList().stream().map(room -> {
                    ScreeningRoomDto roomDto = new ScreeningRoomDto();
                    roomDto.setRoomName(room.getRoomName());
                    return roomDto;
                }).toList())
                .orElseGet(Collections::emptyList);
    }

    @Override
    public List<MovieDto> getMovieByCinema(Long cinemaID) {
        return cinemaRepository.findById(cinemaID)
                .map(cinema -> cinema.getScreeningRoomList().stream()
                        .flatMap(screeningRoom -> screeningRoom.getShowtimeList().stream()) // Lấy danh sách showtime từ mỗi phòng chiếu
                        .map(showtime -> showtime.getMovie()) // Lấy phim từ showtime
                        .distinct() // Để loại bỏ phim trùng lặp
                        .map(movie -> {
                            MovieDto movieDto = new MovieDto();
                            movieDto.setMovieName(movie.getMovieName());
                            return movieDto;
                        }).toList())
                .orElseGet(Collections::emptyList);
    }
}
