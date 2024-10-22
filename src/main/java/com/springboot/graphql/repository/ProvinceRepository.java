package com.springboot.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.graphql.model.Province;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
    
}