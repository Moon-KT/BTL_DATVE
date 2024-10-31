package com.example.SB_Week9.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "seat_id")
    private Long seatID;
    private String seatRow;
    private Integer seatNumber;

    @Check(constraints = "status in ('Ghế trống', 'Ghế đang chọn', 'Ghế đang được giữ', 'Ghế đã bán','Ghế đặt trước')")
    private String status;

    @ManyToOne
    @JoinColumn(name = "seat_type_id")
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private ScreeningRoom screeningRoom;
}
