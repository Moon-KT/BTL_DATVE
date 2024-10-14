package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.CinemaDto;
import com.example.SB_Week9.entity.Cinema;
import com.example.SB_Week9.repository.CinemaRepository;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    private CinemaRepository cinemaRepository;

    public Cinema create(CinemaDto cinemaDto) {
        Cinema cinema = new Cinema();
        cinema.setCinemaName(cinemaDto.getCinemaName());
        return cinemaRepository.save(cinema);
    }

    public Iterable<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }
    public Cinema getCinemaById(Long cinemaID) throws Exception {
        return cinemaRepository.findById(cinemaID).orElseThrow(() -> {
            return new Exception("Không tìm thấy rạp chiếu phim có ID :" + cinemaID);
        });
    }

    public Cinema update(Long cinemaID, CinemaDto cinemaDto) throws Exception {
        Cinema cinema = cinemaRepository.findById(cinemaID).orElseThrow(() -> {
            return new Exception("Không tìm thấy rạp chiếu phim có ID :" + cinemaID);
        });
        cinema.setCinemaName(cinemaDto.getCinemaName());
        return cinemaRepository.save(cinema);
    }

    public boolean delete(Long cinemaID) throws Exception {
        Cinema cinema = cinemaRepository.findById(cinemaID).orElseThrow(() -> {
            return new Exception("Không tìm thấy rạp chiếu phim có ID :" + cinemaID);
        });
        cinemaRepository.delete(cinema);
        return true;
    }
}
