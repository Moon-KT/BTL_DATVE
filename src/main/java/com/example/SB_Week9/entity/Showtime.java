package com.example.SB_Week9.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "showtimes")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "showtime_id")
    private Long showtimeID;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;

    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    private List<Ticket> ticketList;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private ScreeningRoom room;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
