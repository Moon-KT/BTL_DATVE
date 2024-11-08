package com.example.SB_Week9.entity;

import com.example.SB_Week9.entity.enumModel.MembershipType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "membership_id")
    private Long membershipID;

    @Column(name = "membership_type")
    @Enumerated(EnumType.STRING)
    private MembershipType membership_type;

    @Column(name = "point_rate") // Tỷ lệ tích điểm
    private Double point_rate;

    @OneToMany(mappedBy = "membership", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> user;
}

