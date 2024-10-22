package com.springboot.graphql.resolver.province;

import org.springframework.stereotype.Component;

import com.springboot.graphql.dto.ProvinceDTO;
import com.springboot.graphql.model.Province;
import com.springboot.graphql.service.province.ProvinceService;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProvinceMutationResolver implements GraphQLMutationResolver {
    private final ProvinceService provinceService;

    public Province addProvince(ProvinceDTO province) {
        return provinceService.add(province);
    }

    public Province updateProvince(Long id, ProvinceDTO province) {
        return provinceService.update(id, province);
    }

    public String deleteProvince(Long id) {
        return provinceService.delete(id);
    }
}
