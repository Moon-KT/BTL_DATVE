package com.example.SB_Week9.entity.key;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Embeddable
@EqualsAndHashCode
public class ComboOfferPromotionKey {
    private Long comboOfferID;
    private Long promotionID;
}
