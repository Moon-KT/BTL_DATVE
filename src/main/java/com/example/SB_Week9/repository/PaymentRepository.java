package com.example.SB_Week9.repository;

import com.example.SB_Week9.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findPaymentsByUserId(Long userId);
}
