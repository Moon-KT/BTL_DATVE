package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.PaymentDto;
import com.example.SB_Week9.entity.BankCard;
import com.example.SB_Week9.entity.Payment;
import com.example.SB_Week9.repository.BankCardRepository;
import com.example.SB_Week9.repository.PaymentRepository;
import com.example.SB_Week9.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BankCardRepository bankCardRepository;

    @Override
    public Payment create(PaymentDto paymentDto) throws Exception {
        Payment payment = new Payment();
        payment.setPaymentType(paymentDto.getPaymentType());
        payment.setTransactionDate(paymentDto.getTransactionDate());
        payment.setBankCard(bankCardRepository.findById(paymentDto.getCardID()).get());
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> reads() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment read(Long paymentID) throws Exception {
        Optional<Payment> payment = paymentRepository.findById(paymentID);
        if (payment.isEmpty()) {
            throw new Exception("Không tìm thấy hóa đơn thanh toán có ID: " + paymentID);
        }
        return payment.get();
    }

    @Override
    public Payment update(Long paymentID, PaymentDto paymentDto) throws Exception {
        Optional<Payment> payment = paymentRepository.findById(paymentID);
        if (payment.isEmpty()) {
            throw new Exception("Không tìm thấy hóa đơn thanh toán có ID: " + paymentID);
        }
        payment.get().setPaymentType(paymentDto.getPaymentType());
        payment.get().setTransactionDate(paymentDto.getTransactionDate());
        payment.get().setBankCard(bankCardRepository.findById(paymentDto.getCardID()).get());

        return paymentRepository.save(payment.get());
    }

    @Override
    public void delete(Long paymentID) throws Exception {
        Optional<Payment> payment = paymentRepository.findById(paymentID);
        if (payment.isEmpty()) {
            throw new Exception("Không tìm thấy hóa đơn thanh toán có ID: " + paymentID);
        }
        paymentRepository.delete(payment.get());
    }
}
