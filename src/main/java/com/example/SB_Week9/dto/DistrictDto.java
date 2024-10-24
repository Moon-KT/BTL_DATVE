package com.example.SB_Week9.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDto {
    private Long districtID;

    @Nationalized
    private String district;

    private Long locationID;
}
