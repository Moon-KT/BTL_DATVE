package com.example.SB_Week9.entity.key;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Embeddable
@EqualsAndHashCode
public class TicketComboOfferKey {
    private Long ticketID;
    private Long comboOfferID;
}
