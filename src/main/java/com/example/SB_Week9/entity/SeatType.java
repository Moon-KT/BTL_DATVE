package com.example.SB_Week9.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.List;
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

    @Column(name = "seat_type_id")
    private Long seatTypeID;

    @Nationalized
    private String seatTypeName;

    private Double seatPrice;

    @OneToMany(mappedBy = "seatType", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Seat> seatList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private ScreeningRoom room;
}
