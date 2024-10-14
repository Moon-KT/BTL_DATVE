package com.example.SB_Week9.dto;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PromotionDto {
    private Long promotionID;
    private String promotionName;
    private String promotionDescription;
    private String promotionStartDate;
    private String promotionEndDate;
    private String discount;
}
