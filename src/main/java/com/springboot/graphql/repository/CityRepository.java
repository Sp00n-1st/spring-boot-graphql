package com.springboot.graphql.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.graphql.model.City;
import com.springboot.graphql.model.Province;

public interface CityRepository extends JpaRepository<City, Long> {

    Page<City> findAllByProvince(Province province, Pageable page);

}
