package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.DistrictDto;
import com.example.SB_Week9.entity.District;
import com.example.SB_Week9.entity.Location;
import com.example.SB_Week9.repository.DistrictRepository;
import com.example.SB_Week9.repository.LocationRepository;
import com.example.SB_Week9.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public District create(DistrictDto districtDto) throws Exception {
        Optional<Location> locationOptional = Optional.ofNullable(locationRepository.findById(districtDto.getLocationID()))
                .orElseThrow(() -> { return new Exception("Không tìm thấy địa điểm có ID: " + districtDto.getLocationID());
                });

        District newDistrict = new District();
        newDistrict.setDistrict(districtDto.getDistrict());
        newDistrict.setLocation(locationOptional.get());
        return districtRepository.save(newDistrict);
    }

    @Override
    public List<District> reads() {
        return districtRepository.findAll();
    }

    @Override
    public District read(Long districtID) throws Exception {
        Optional<District> districtOptional = Optional.ofNullable(districtRepository.findById(districtID))
                .orElseThrow(() -> {
                    return new Exception("Không tìm thấy quận/huyện có ID: " + districtID);
                });
        return districtOptional.get();
    }

    @Override
    public District update(Long districtID, DistrictDto districtDto) throws Exception {
        Optional<District> district = Optional.ofNullable(districtRepository.findById(districtID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy quận/huyện có ID: " + districtID);
                });
        district.get().setDistrict(districtDto.getDistrict());
        return district.get();
    }

    @Override
    public void delete(Long districtID) throws Exception {
        Optional<District> district = Optional.ofNullable(districtRepository.findById(districtID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy quận/huyện có ID: " + districtID);
                });
        districtRepository.delete(district.get());
    }
}
