package com.example.SB_Week9.dto;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentDto {
    private Long paymentID;
    private String paymentType;
    private String transactionDate;
}
