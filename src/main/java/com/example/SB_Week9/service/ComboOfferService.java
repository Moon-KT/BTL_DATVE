package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.ComboOfferDto;
import com.example.SB_Week9.entity.ComboOffer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComboOfferService {
    ComboOffer create(ComboOfferDto comboOfferDto) throws Exception;
    List<ComboOffer> reads();
    ComboOffer read(Long comboOfferID) throws Exception;
    ComboOffer update(Long comboOfferID, ComboOfferDto comboOfferDto) throws Exception;
    void delete(Long comboOfferID) throws Exception;
}
