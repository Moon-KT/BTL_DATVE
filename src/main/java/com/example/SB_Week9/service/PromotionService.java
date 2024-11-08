package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.PromotionDto;
import com.example.SB_Week9.entity.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PromotionService {
    //CRUD
    PromotionDto create(PromotionDto promotionDto) throws Exception;
    List<PromotionDto> reads();
    PromotionDto read(Long promotionID) throws Exception;
    PromotionDto update(Long promotionID, PromotionDto promotionDto) throws Exception;
    void delete(Long promotionID) throws Exception;

    //Other


}
