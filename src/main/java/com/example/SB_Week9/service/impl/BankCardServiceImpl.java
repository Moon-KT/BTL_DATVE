package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.BankCardDto;
import com.example.SB_Week9.entity.BankCard;
import com.example.SB_Week9.entity.Cinema;
import com.example.SB_Week9.repository.BankCardRepository;
import com.example.SB_Week9.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankCardServiceImpl implements BankCardService {
    @Autowired
    private BankCardRepository bankCardRepository;

    @Override
    public List<BankCard> reads() {
        return bankCardRepository.findAll();
    }

    @Override
    public BankCard read(Long bankCardID) throws Exception {
        Optional<BankCard> bankCard = Optional.ofNullable(bankCardRepository.findById(bankCardID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy thẻ có ID: " + bankCardID);
                });
        return bankCard.get();
    }

    @Override
    public BankCard create(BankCardDto bankCardDto) throws Exception {
        BankCard bankCard = new BankCard();

        bankCard.setBankName(bankCardDto.getBankName());
        bankCard.setCardNumber(bankCardDto.getCardNumber());
        bankCard.setCardholderName(bankCardDto.getCardholderName());
        bankCard.setExpirationDate(bankCardDto.getExpirationDate());

        return bankCardRepository.save(bankCard);
    }

    @Override
    public BankCard update(Long bankCardID, BankCardDto bankCardDto) throws Exception {
        Optional<BankCard> bankCard = Optional.ofNullable(bankCardRepository.findById(bankCardID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy thẻ có ID: " + bankCardID);
                });
        bankCard.get().setCardholderName(bankCardDto.getCardholderName());
        bankCard.get().setBankName(bankCardDto.getBankName());
        bankCard.get().setExpirationDate(bankCardDto.getExpirationDate());
        return bankCard.get();
    }

    @Override
    public void delete(Long bankCardID) throws Exception{
        Optional<BankCard> bankCard = Optional.ofNullable(bankCardRepository.findById(bankCardID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy thẻ có ID: " + bankCardID);
                });
        bankCardRepository.delete(bankCard.get());
    }
}
