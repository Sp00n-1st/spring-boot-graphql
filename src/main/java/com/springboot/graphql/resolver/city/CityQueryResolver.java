package com.springboot.graphql.resolver.city;

import org.springframework.stereotype.Component;

import com.springboot.graphql.model.City;
import com.springboot.graphql.service.city.CityService;
import java.util.List;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CityQueryResolver implements GraphQLQueryResolver {
    private final CityService cityService;

    public City getCityById(Long id) {
        return cityService.getById(id);
    }

    public List<City> getCities(Integer page, Integer size) {
        return cityService.getCities(page, size);
    }

    public List<City> getCitiesByProvinceId(Long provinceId, Integer page, Integer size) {
        return cityService.getCitiesByProvince(provinceId, page, size);
    }
}
