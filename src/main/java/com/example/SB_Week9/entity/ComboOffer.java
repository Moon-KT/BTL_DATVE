package com.example.SB_Week9.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "combo_offers")
public class ComboOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "combo_id")
    private Long comboID;

    @Nationalized
    @Column(length = 1000)
    private String comboDescription;

    private String imageCombo;
    private Double price;

}
