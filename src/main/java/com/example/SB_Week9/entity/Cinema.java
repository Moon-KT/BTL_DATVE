package com.example.SB_Week9.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cinemas")
public class Cinema {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)

    @Column(name = "cinema_id")
    private Long cinemaID;

    @Nationalized
    private String cinemaName;

    @Column(length = 11)
    private String hotline;

    @Nationalized
    @Column(length = 600)
    private String detailedAddress;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    @JsonIgnore
    List<ScreeningRoom> screeningRoomList;
}
