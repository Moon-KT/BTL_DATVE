package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.ComboOfferDto;
import com.example.SB_Week9.entity.ComboOffer;
import com.example.SB_Week9.repository.ComboOfferRepository;
import com.example.SB_Week9.service.ComboOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class ComboOfferServiceIml implements ComboOfferService {
    private final ComboOfferRepository comboOfferRepository;

    @Autowired
    public ComboOfferServiceIml(ComboOfferRepository comboOfferRepository) {
        this.comboOfferRepository = comboOfferRepository;
    }

    private ComboOfferDto convertToDto(ComboOffer comboOffer) {
        return ComboOfferDto.builder()
                .comboDescription(comboOffer.getComboDescription())
                .imageCombo(comboOffer.getImageCombo())
                .price(comboOffer.getPrice())
                .build();
    }

    @Override
    public ComboOfferDto create(ComboOfferDto comboOfferDto) throws Exception {
        ComboOffer comboOffer = ComboOffer.builder()
                .comboDescription(comboOfferDto.getComboDescription())
                .imageCombo(comboOfferDto.getImageCombo())
                .price(comboOfferDto.getPrice())
                .build();
        return convertToDto(comboOfferRepository.save(comboOffer));
    }

    @Override
    public List<ComboOfferDto> reads() {
        return comboOfferRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public ComboOfferDto read(Long comboOfferID) throws Exception {
        return comboOfferRepository.findById(comboOfferID)
                .map(this::convertToDto)
                .orElseThrow(() -> { return new Exception("Không tìm thấy combo có ID: " + comboOfferID);
                });
    }

    @Override
    public ComboOfferDto update(Long comboOfferID, ComboOfferDto comboOfferDto) throws Exception {
        ComboOffer comboOffer = comboOfferRepository.findById(comboOfferID)
                .orElseThrow(() -> { return new Exception("Không tìm thấy combo có ID: " + comboOfferID);
                });

        comboOffer.toBuilder()
                .comboDescription(comboOfferDto.getComboDescription())
                .imageCombo(comboOfferDto.getImageCombo())
                .price(comboOfferDto.getPrice())
                .build();
        return convertToDto(comboOfferRepository.save(comboOffer));
    }

    @Override
    public void delete(Long comboOfferID) throws Exception {
        if (!comboOfferRepository.existsById(comboOfferID)) {
            throw new Exception("Không tìm thấy combo có ID: " + comboOfferID);
        }
        comboOfferRepository.deleteById(comboOfferID);
    }
}
