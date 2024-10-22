package com.springboot.graphql.service.city;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.graphql.dto.CityDTO;
import com.springboot.graphql.model.City;
import com.springboot.graphql.repository.CityRepository;
import com.springboot.graphql.repository.ProvinceRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final ProvinceRepository provinceRepository;

    @Override
    @Transactional
    public City add(CityDTO city) {
        try {
            return cityRepository.save(City.builder()
                    .name(city.getName())
                    .postalCode(city.getPostalCode())
                    .population(city.getPopulation())
                    .area(city.getArea())
                    .province(provinceRepository.findById(city.getProvinceId())
                            .orElseThrow(() -> new RuntimeException("")))
                    .build());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    @Override
    @Transactional
    public City update(Long id, CityDTO city) {
        try {
            City ct = cityRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
            ct.setName(city.getName());
            ct.setPostalCode(city.getPostalCode());
            ct.setPopulation(city.getPopulation());
            ct.setArea(city.getArea());
            ct.setProvince(
                    provinceRepository.findById(city.getProvinceId()).orElseThrow(() -> new RuntimeException("")));

            return cityRepository.save(ct);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    @Override
    @Transactional
    public String delete(Long id) {
        try {
            cityRepository.deleteById(id);
            return "Successfully Delete City";
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public City getById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public List<City> getCities(Integer page, Integer size) {
        return cityRepository.findAll(PageRequest.of(page < 1 ? 0 : (page - 1), size)).toList();
    }

    @Override
    public List<City> getCitiesByProvince(Long provinceId, Integer page, Integer size) {
        return cityRepository
                .findAllByProvince(provinceRepository.findById(provinceId).orElseThrow(() -> new RuntimeException("")),
                        PageRequest.of(page < 1 ? 0 : (page - 1), size))
                .toList();
    }
}
