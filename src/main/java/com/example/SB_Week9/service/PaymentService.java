package com.example.SB_Week9.service;

import com.example.SB_Week9.dto.PaymentDto;
import com.example.SB_Week9.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    Payment create(PaymentDto paymentDto) throws Exception;
    List<Payment> reads();
    Payment read(Long paymentID) throws Exception;
    Payment update(Long paymentID, PaymentDto paymentDto) throws Exception;
    void delete(Long paymentID) throws Exception;
}
