package com.springboot.graphql.service.province;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.graphql.dto.ProvinceDTO;
import com.springboot.graphql.model.Province;
import com.springboot.graphql.repository.ProvinceRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;

    @Override
    @Transactional
    public Province add(ProvinceDTO province) {
        try {
            return provinceRepository.save(Province.builder()
                    .provinceId(province.getProvinceId())
                    .name(province.getName())
                    .code(province.getCode())
                    .capital(province.getCapital())
                    .population(province.getPopulation())
                    .area(province.getArea())
                    .build());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    @Override
    @Transactional
    public Province update(Long id, ProvinceDTO province) {
        try {
            Province prov = provinceRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
            prov.setName(province.getName());
            prov.setCode(province.getCode());
            prov.setPopulation(province.getPopulation());
            prov.setCapital(province.getCapital());
            prov.setArea(province.getArea());

            return provinceRepository.save(prov);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }

    }

    @Override
    @Transactional
    public String delete(Long id) {
        try {
            provinceRepository.deleteById(id);
            return "Successfully Delete Province";
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public Province getById(Long id) {
        return provinceRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public List<Province> getProvinces(Integer page, Integer size) {
        return provinceRepository.findAll(PageRequest.of(page < 1 ? 0 : (page - 1), size)).toList();
    }
}
