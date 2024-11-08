package com.example.SB_Week9.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "golden_time_slots")
public class GoldenTimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "golden_time_slot_id")
    private Long goldenTimeSlotID;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;
}
