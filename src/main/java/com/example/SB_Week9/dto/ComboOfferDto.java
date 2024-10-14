package com.example.SB_Week9.dto;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ComboOfferDto {
    private Long comboID;
    private String comboDescription;
    private String image;
    private double price;
}
