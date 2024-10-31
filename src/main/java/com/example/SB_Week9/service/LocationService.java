package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.CinemaDto;
import com.example.SB_Week9.dto.LocationDto;
import com.example.SB_Week9.entity.Cinema;
import com.example.SB_Week9.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    Location create(LocationDto locationDto) throws Exception;
    List<Location> reads();
    Location read(Long locationID) throws Exception;
    Location update(Long locationID, LocationDto locationDto) throws Exception;
    void delete(Long locationID) throws Exception;
    List<Cinema> getCinemaByLocation(Long locationID);
}
