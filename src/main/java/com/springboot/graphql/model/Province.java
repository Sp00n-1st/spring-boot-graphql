package com.springboot.graphql.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.graphql.serialization.province.ProvinceSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "province")
@JsonSerialize(using = ProvinceSerializer.class)
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long provinceId;

    private String name;
    private String code;
    private String capital;
    private long population;
    private double area;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    private Set<City> cities;
}
