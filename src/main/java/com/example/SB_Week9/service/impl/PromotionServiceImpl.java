package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.PromotionDto;
import com.example.SB_Week9.entity.Promotion;
import com.example.SB_Week9.repository.PromotionRepository;
import com.example.SB_Week9.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;

    private PromotionDto convertToDto(Promotion promotion) {
        return PromotionDto.builder()
                .promotionDescription(promotion.getPromotionDescription())
                .promotionStartDate(promotion.getPromotionStartDate())
                .promotionEndDate(promotion.getPromotionEndDate())
                .promotionType(promotion.getPromotionType())
                .build();
    }

    @Override
    public PromotionDto create(PromotionDto promotionDto) throws Exception {
        Promotion promotion = Promotion.builder()
                .promotionDescription(promotionDto.getPromotionDescription())
                .promotionStartDate(promotionDto.getPromotionStartDate())
                .promotionEndDate(promotionDto.getPromotionEndDate())
                .promotionType(promotionDto.getPromotionType())
                .price(promotionDto.getPrice())
                .build();
        return convertToDto(promotionRepository.save(promotion));
    }

    @Override
    public List<PromotionDto> reads() {
        return promotionRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public PromotionDto read(Long promotionID) throws Exception {
        return promotionRepository.findById(promotionID)
                .map(this::convertToDto)
                .orElseThrow(() -> new Exception("Promotion not found"));
    }

    @Override
    public PromotionDto update(Long promotionID, PromotionDto promotionDto) throws Exception {
        Promotion existingPromotion = promotionRepository.findById(promotionID)
                .orElseThrow(() -> new Exception("Promotion not found"));
        return convertToDto(promotionRepository.save(existingPromotion.toBuilder()
                .promotionDescription(promotionDto.getPromotionDescription())
                .promotionStartDate(promotionDto.getPromotionStartDate())
                .promotionEndDate(promotionDto.getPromotionEndDate())
                .promotionType(promotionDto.getPromotionType())
                        .price(promotionDto.getPrice())
                .build()));
    }

    @Override
    public void delete(Long promotionID) throws Exception {
        if(!promotionRepository.existsById(promotionID)) {
            throw new Exception("Promotion not found");
        }
        promotionRepository.deleteById(promotionID);
    }
}
