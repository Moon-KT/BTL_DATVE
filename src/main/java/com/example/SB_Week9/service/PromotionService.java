package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.PromotionDto;
import com.example.SB_Week9.entity.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PromotionService {
    Promotion create(PromotionDto promotionDto) throws Exception;
    List<Promotion> reads();
    Promotion read(Long promotionID) throws Exception;
    Promotion update(Long promotionID, PromotionDto promotionDto) throws Exception;
    void delete(Long promotionID) throws Exception;
}
