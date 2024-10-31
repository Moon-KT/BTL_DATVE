package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.CinemaDto;
import com.example.SB_Week9.dto.LocationDto;
import com.example.SB_Week9.entity.Cinema;
import com.example.SB_Week9.entity.Location;
import com.example.SB_Week9.repository.LocationRepository;
import com.example.SB_Week9.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location create(LocationDto locationDto) throws Exception {
        Location newLocation = new Location();
        newLocation.setCity(locationDto.getCity());
        return locationRepository.save(newLocation);
    }

    @Override
    public List<Location> reads() {
        return locationRepository.findAll();
    }

    @Override
    public Location read(Long locationID) throws Exception {
        Optional<Location> locationOptional = Optional.ofNullable(locationRepository.findById(locationID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy địa điểm có ID: " + locationID);
                });
        return locationOptional.get();
    }

    @Override
    public Location update(Long locationID, LocationDto locationDto) throws Exception {
        Optional<Location> locationOptional = Optional.ofNullable(locationRepository.findById(locationID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy địa điểm có ID: " + locationID);
                });
        locationOptional.get().setCity(locationDto.getCity());
        return locationOptional.get();
    }

    @Override
    public void delete(Long locationID) throws Exception {
        Optional<Location> locationOptional = Optional.ofNullable(locationRepository.findById(locationID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy địa điểm có ID: " + locationID);
                });
        locationRepository.delete(locationOptional.get());
    }

    @Override
    public List<Cinema> getCinemaByLocation(Long locationID) {
        return locationRepository.findById(locationID).get().getCinemaList();
    }
}
