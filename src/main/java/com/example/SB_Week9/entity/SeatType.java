package com.example.SB_Week9.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seat_types")
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatTypeID;
    private String seatTypeName;

    @OneToMany(mappedBy = "seatType", cascade = CascadeType.ALL)
    private Set<Seat> seats;
}
