package com.example.SB_Week9.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ComboOfferDto {
    @Nationalized
    @Column(length = 1000)
    private String comboDescription;
    private String imageCombo;
    private double price;
}
