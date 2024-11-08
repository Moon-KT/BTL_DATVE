package com.example.SB_Week9.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "booking_id")
    private Long bookingID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    private Double totalPrice;

    private Double pointsEarned; // Điểm tích lũy từ booking này

    private LocalDateTime bookingTime;

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Booking_Seat> booking_seats;

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Booking_Seat> booking_seatList;

    @PrePersist
    public void calculatePoints(){
        if (user != null && user.getMembership() != null) {
            // Tính điểm tích lũy dựa trên tỷ lệ từ Membership
            this.pointsEarned = totalPrice * user.getMembership().getPoint_rate();
        } else {
            this.pointsEarned = 0.0;  // Nếu không có Membership, không tính điểm
        }
    }
}
