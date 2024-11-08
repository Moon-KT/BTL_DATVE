package com.example.SB_Week9.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.*;
import org.hibernate.annotations.Nationalized;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComboOfferDto {
    private String comboDescription;
    private String imageCombo;
    private double price;
}
