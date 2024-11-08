package com.example.SB_Week9.entity;

import com.example.SB_Week9.entity.enumModel.PromotionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "promotion_id")
    private Long promotionID;

    @Nationalized
    @Column(name = "promotion_description",length = 1000)
    private String promotionDescription;

    @Column(name = "promotion_start_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime promotionStartDate;

    @Column(name = "promotion_end_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime promotionEndDate;

    @Column(name = "promotion_price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "promotion_type")
    private PromotionType promotionType;

}
