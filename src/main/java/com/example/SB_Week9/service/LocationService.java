package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.CinemaDto;
import com.example.SB_Week9.dto.LocationDto;
import com.example.SB_Week9.entity.Cinema;
import com.example.SB_Week9.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    //CRUD
    LocationDto create(LocationDto locationDto) throws Exception;
    List<LocationDto> reads();
    LocationDto read(Long locationID) throws Exception;
    LocationDto update(Long locationID, LocationDto locationDto) throws Exception;
    void delete(Long locationID) throws Exception;

    //Other
    List<CinemaDto> getCinemaByLocation(Long locationID);
}
