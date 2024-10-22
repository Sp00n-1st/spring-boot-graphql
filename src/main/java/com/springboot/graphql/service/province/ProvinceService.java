package com.springboot.graphql.service.province;

import java.util.List;

import com.springboot.graphql.dto.ProvinceDTO;
import com.springboot.graphql.model.Province;

public interface ProvinceService {

    Province add(ProvinceDTO province);

    Province update(Long id, ProvinceDTO province);

    String delete(Long id);

    Province getById(Long id);

    List<Province> getProvinces(Integer page, Integer size);
}
