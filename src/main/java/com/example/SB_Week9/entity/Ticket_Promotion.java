package com.example.SB_Week9.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_promotion")
public class Ticket_Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;
}
