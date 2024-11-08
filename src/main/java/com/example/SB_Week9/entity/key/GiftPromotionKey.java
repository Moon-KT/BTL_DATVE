package com.example.SB_Week9.entity.key;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Embeddable
@EqualsAndHashCode
public class GiftPromotionKey {
    private Long giftID;
    private Long promotionID;
}
