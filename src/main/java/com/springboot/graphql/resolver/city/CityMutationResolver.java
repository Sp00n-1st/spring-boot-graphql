package com.springboot.graphql.resolver.city;

import org.springframework.stereotype.Component;

import com.springboot.graphql.dto.CityDTO;
import com.springboot.graphql.model.City;
import com.springboot.graphql.service.city.CityService;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CityMutationResolver implements GraphQLMutationResolver {
    private final CityService cityService;

    public City addCity(CityDTO city) {
        return cityService.add(city);
    }

    public City updateCity(Long id, CityDTO city) {
        return cityService.update(id, city);
    }

    public String deleteCity(Long id) {
        return cityService.delete(id);
    }
}
