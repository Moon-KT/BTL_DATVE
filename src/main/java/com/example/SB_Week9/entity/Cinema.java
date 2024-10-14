package com.example.SB_Week9.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cinemas")
public class Cinema {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long cinemaID;
    private String cinemaName;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
