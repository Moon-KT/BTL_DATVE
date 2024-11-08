package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.CinemaDto;
import com.example.SB_Week9.dto.LocationDto;
import com.example.SB_Week9.entity.Cinema;
import com.example.SB_Week9.entity.Location;
import com.example.SB_Week9.repository.CinemaRepository;
import com.example.SB_Week9.repository.LocationRepository;
import com.example.SB_Week9.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private CinemaRepository cinemaRepository;

    private LocationDto convertToDto(Location location) {
        return LocationDto.builder()
                .city(location.getCity())
                .build();
    }
    @Override
    public LocationDto create(LocationDto locationDto) throws Exception {
        Location location = Location.builder()
                .city(locationDto.getCity())
                .build();
        return convertToDto(locationRepository.save(location));
    }

    @Override
    public List<LocationDto> reads() {
        return locationRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public LocationDto read(Long locationID) throws Exception {
        return locationRepository.findById(locationID)
                .map(this::convertToDto)
                .orElseThrow(() -> { return new Exception("Không tìm thấy địa điểm có ID: " + locationID);
                });
    }

    @Override
    public LocationDto update(Long locationID, LocationDto locationDto) throws Exception {
        Location location = locationRepository.findById(locationID)
                .orElseThrow(() -> { return new Exception("Không tìm thấy địa điểm có ID: " + locationID);
                });
        location.toBuilder()
                .city(locationDto.getCity())
                .build();
        return convertToDto(locationRepository.save(location));
    }

    @Override
    public void delete(Long locationID) throws Exception {
        if(!locationRepository.existsById(locationID)) {
            throw new Exception("Không tìm thấy địa điểm có ID: " + locationID);
        }
    }

    @Override
    public List<CinemaDto> getCinemaByLocation(Long locationID) {
        List<Cinema> cinemas = cinemaRepository.findByLocationLocationID(locationID);
        return cinemas.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private CinemaDto convertToDto(Cinema cinema) {
        return CinemaDto.builder()
                .cinemaName(cinema.getCinemaName())
                .locationID(cinema.getLocation().getLocationID())
                .build();
    }
}
