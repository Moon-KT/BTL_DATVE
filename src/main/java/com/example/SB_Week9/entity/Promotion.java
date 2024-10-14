package com.example.SB_Week9.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promotionID;
    private String promotionName;
    private String promotionDescription;
    private String promotionStartDate;
    private String promotionEndDate;
    private String discount;
}
