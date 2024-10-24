package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.ComboOfferDto;
import com.example.SB_Week9.entity.ComboOffer;
import com.example.SB_Week9.repository.ComboOfferRepository;
import com.example.SB_Week9.service.ComboOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComboOfferServiceIml implements ComboOfferService {
    @Autowired
    ComboOfferRepository comboOfferRepository;

    @Override
    public ComboOffer create(ComboOfferDto comboOfferDto) throws Exception {
        ComboOffer comboOffer = new ComboOffer();

        comboOffer.setComboDescription(comboOfferDto.getComboDescription());
        comboOffer.setImageCombo(comboOfferDto.getImageCombo());
        comboOffer.setPrice(comboOfferDto.getPrice());

        return comboOfferRepository.save(comboOffer);
    }

    @Override
    public List<ComboOffer> reads() {
        return comboOfferRepository.findAll();
    }

    @Override
    public ComboOffer read(Long comboOfferID) throws Exception {
        Optional<ComboOffer> comboOffer = Optional.ofNullable(comboOfferRepository.findById(comboOfferID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy combo có ID: " + comboOfferID);
                });
        return comboOffer.get();
    }

    @Override
    public ComboOffer update(Long comboOfferID, ComboOfferDto comboOfferDto) throws Exception {
        Optional<ComboOffer> comboOffer = Optional.ofNullable(comboOfferRepository.findById(comboOfferID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy combo có ID: " + comboOfferID);
                });
        comboOffer.get().setComboDescription(comboOfferDto.getComboDescription());
        comboOffer.get().setImageCombo(comboOfferDto.getImageCombo());
        comboOffer.get().setPrice(comboOfferDto.getPrice());
        return comboOffer.get();
    }

    @Override
    public void delete(Long comboOfferID) throws Exception {
        Optional<ComboOffer> comboOffer = Optional.ofNullable(comboOfferRepository.findById(comboOfferID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy combo có ID: " + comboOfferID);
                });
        comboOfferRepository.delete(comboOffer.get());
    }
}
