package com.example.SB_Week9.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "combo_offers")
public class ComboOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comboID;
    private String comboDescription;
    private String image;
    private double price;

    @ManyToMany(mappedBy = "comboOffers")
    private Set<Ticket> tickets;
}
