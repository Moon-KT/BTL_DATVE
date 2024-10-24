package com.example.SB_Week9.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ticket_combo_offer")
public class Ticket_ComboOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "combo_id")
    private ComboOffer comboOffer;
}
