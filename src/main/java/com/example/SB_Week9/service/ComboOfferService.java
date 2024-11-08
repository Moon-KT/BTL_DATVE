package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.ComboOfferDto;
import com.example.SB_Week9.entity.ComboOffer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComboOfferService {
    //CRUD
    ComboOfferDto create(ComboOfferDto comboOfferDto) throws Exception;
    List<ComboOfferDto> reads();
    ComboOfferDto read(Long comboOfferID) throws Exception;
    ComboOfferDto update(Long comboOfferID, ComboOfferDto comboOfferDto) throws Exception;
    void delete(Long comboOfferID) throws Exception;

    //Other
}
