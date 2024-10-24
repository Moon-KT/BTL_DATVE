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

    @Override
    public Promotion create(PromotionDto promotionDto) throws Exception {
        Promotion promotion = new Promotion();

        promotion.setPromotionDescription(promotionDto.getPromotionDescription());
        promotion.setPromotionStartDate(promotionDto.getPromotionStartDate());
        promotion.setPromotionEndDate(promotionDto.getPromotionEndDate());
        promotion.setDiscount(promotionDto.getDiscount());
        return promotionRepository.save(promotion);
    }

    @Override
    public List<Promotion> reads() {
        return promotionRepository.findAll();
    }

    @Override
    public Promotion read(Long promotionID) throws Exception {
        Optional<Promotion> promotion = Optional.ofNullable(promotionRepository.findById(promotionID))
                .orElseThrow(() -> { return new Exception("Promotion not found");});
        return promotion.get();
    }

    @Override
    public Promotion update(Long promotionID, PromotionDto promotionDto) throws Exception {
        Optional<Promotion> promotion = Optional.ofNullable(promotionRepository.findById(promotionID))
                .orElseThrow(() -> { return new Exception("Promotion not found");});

        promotion.get().setPromotionDescription(promotionDto.getPromotionDescription());
        promotion.get().setPromotionStartDate(promotionDto.getPromotionStartDate());
        promotion.get().setPromotionEndDate(promotionDto.getPromotionEndDate());
        promotion.get().setDiscount(promotionDto.getDiscount());
        return promotionRepository.save(promotion.get());
    }

    @Override
    public void delete(Long promotionID) throws Exception {
        Optional<Promotion> promotion = Optional.ofNullable(promotionRepository.findById(promotionID))
                .orElseThrow(() -> { return new Exception("Promotion not found");});
        promotionRepository.delete(promotion.get());
    }
}
