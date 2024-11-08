package com.example.SB_Week9.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.text.DecimalFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "gifts")
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "gift_id")
    private Long giftID;

    @Column(name = "gift_name", length = 50)
    private String giftName;

    @Column(name = "gift_description", length = 1000)
    private String giftDescription;

    @Column(name = "gift_image", length = 1000)
    private String giftImage;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
