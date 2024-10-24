package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.BankCardDto;
import com.example.SB_Week9.entity.BankCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankCardService {
    public List<BankCard> reads();
    BankCard read(Long bankCardID) throws Exception;
    BankCard create(BankCardDto bankCardDto) throws Exception;
    BankCard update(Long bankCardID, BankCardDto bankCardDto) throws Exception;
    void delete(Long bankCardID) throws Exception;


}
