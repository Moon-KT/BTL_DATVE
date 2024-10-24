package com.example.SB_Week9.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

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

    @Nationalized
    @Column(length = 1000)
    private String comboDescription;

    private String imageCombo;
    private double price;

    @OneToMany(mappedBy = "comboOffer", cascade = CascadeType.ALL)
    private List<Ticket_ComboOffer> ticket_comboOfferList;
}
