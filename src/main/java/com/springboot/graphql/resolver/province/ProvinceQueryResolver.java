package com.springboot.graphql.resolver.province;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.graphql.model.Province;
import com.springboot.graphql.service.province.ProvinceService;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProvinceQueryResolver implements GraphQLQueryResolver {
    private final ProvinceService provinceService;

    public Province getProvinceById(Long id) {
        return provinceService.getById(id);
    }

    public List<Province> getProvinces(Integer page, Integer size) {
        return provinceService.getProvinces(page, size);
    }
}
