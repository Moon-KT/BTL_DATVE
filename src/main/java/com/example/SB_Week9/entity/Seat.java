package com.example.SB_Week9.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatID;
    private int seatNumber;
    private String status; // Available, Booked, Locked

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> ticketList;

    @ManyToOne
    @JoinColumn(name = "seat_type_id")
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;
}
