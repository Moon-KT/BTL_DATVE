package com.example.SB_Week9.entity.key;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class TicketPromotionKey {
    private Long ticketID;
    private Long promotionID;
}
