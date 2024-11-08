package com.example.SB_Week9.dto;

import com.example.SB_Week9.entity.enumModel.MembershipType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MembershipDto {
    private MembershipType membershipType;
    private Double point_rate;
}
