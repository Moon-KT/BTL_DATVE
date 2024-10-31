package com.example.SB_Week9.entity;

import com.example.SB_Week9.dto.CinemaDto;
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
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)

    @Column(name = "location_id")
    private Long locationID;

    @Nationalized
    private String city;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cinema> cinemaList;
}
