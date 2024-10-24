package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.DistrictDto;
import com.example.SB_Week9.entity.District;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DistrictService {
    District create(DistrictDto districtDto) throws Exception;
    List<District> reads();
    District read(Long districtID) throws Exception;
    District update(Long districtID, DistrictDto districtDto) throws Exception;
    void delete(Long districtID) throws Exception;
}
