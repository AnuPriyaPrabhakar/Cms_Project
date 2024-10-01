package com.ponsun.cms.countryHq.services;


import com.ponsun.cms.countryHq.domain.CountryHq;
import com.ponsun.cms.countryHq.domain.CountryHqRepository;
import com.ponsun.cms.countryHq.domain.CountryHqRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryHqReadPlatformServiceImpl implements CountryHqReadPlatformService {
    private final CountryHqRepositoryWrapper countryHqRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CountryHqRepository countryHqRepository;
    @Override
    public CountryHq fetchCountryHqById(Integer id){
        return this.countryHqRepository.findById(id).get();
    }
    @Override
    public List<CountryHq> fetchAllCountryHq(){ return this.countryHqRepository.findAll();}
}
