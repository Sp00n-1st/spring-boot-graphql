package com.springboot.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
    private Long cityId;
    private String name;
    private String postalCode;
    private long population;
    private double area;
    private Long provinceId;
}
