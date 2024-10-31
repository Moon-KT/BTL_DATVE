package com.example.SB_Week9.entity;

import com.example.SB_Week9.entity.key.TicketPromotionKey;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "ticket_promotion")
public class Ticket_Promotion {
    @EmbeddedId
    private TicketPromotionKey id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", insertable = false, updatable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "promotion_id", insertable = false, updatable = false)
    private Promotion promotion;
}
