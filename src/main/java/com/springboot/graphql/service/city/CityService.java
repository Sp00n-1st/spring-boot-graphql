package com.springboot.graphql.service.city;

import java.util.List;

import com.springboot.graphql.dto.CityDTO;
import com.springboot.graphql.model.City;

public interface CityService {

    City add(CityDTO province);

    City update(Long id, CityDTO city);

    String delete(Long id);

    City getById(Long id);

    List<City> getCities(Integer page, Integer size);

    List<City> getCitiesByProvince(Long provinceId, Integer page, Integer size);

}
