package com.example.SB_Week9.entity.key;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class TicketComboOfferKey implements Serializable {
    private Long ticketID;
    private Long comboID;
}
