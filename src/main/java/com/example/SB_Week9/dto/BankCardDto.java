package com.example.SB_Week9.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankCardDto {
    private String cardNumber;

    @Nationalized
    private String cardholderName;
    private LocalDateTime expirationDate;

    @Nationalized
    private String bankName;


}
