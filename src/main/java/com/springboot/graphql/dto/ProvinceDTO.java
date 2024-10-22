package com.springboot.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceDTO {
    private Long provinceId;
    private String name;
    private String code;
    private String capital;
    private Long population;
    private double area;
}