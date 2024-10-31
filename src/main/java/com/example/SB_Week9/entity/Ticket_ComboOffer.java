package com.example.SB_Week9.entity;

import com.example.SB_Week9.entity.key.TicketComboOfferKey;
import jakarta.persistence.*;

@Entity
@Table(name = "ticket_combo_offer")
public class Ticket_ComboOffer {
    @EmbeddedId
    private TicketComboOfferKey id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", insertable = false, updatable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "combo_id", insertable = false, updatable = false)
    private ComboOffer comboOffer;
}
