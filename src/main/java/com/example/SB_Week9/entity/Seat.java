package com.example.SB_Week9.entity;

import com.example.SB_Week9.entity.enumModel.SeatStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "seat_id")
    private Long seatID;

    @Column(name = "seat_row")
    private String seatRow;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @ManyToOne
    @JoinColumn(name = "seat_type_id")
    private SeatType seatType;

    @OneToMany(mappedBy = "seat")
    @JsonIgnore
    private List<Booking_Seat> bookingSeatList;

    @OneToMany(mappedBy = "seat")
    @JsonIgnore
    private List<Ticket> ticketList;
}
