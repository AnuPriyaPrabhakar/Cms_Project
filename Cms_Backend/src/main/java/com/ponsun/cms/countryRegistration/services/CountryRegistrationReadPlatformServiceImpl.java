package com.ponsun.cms.countryRegistration.services;


import com.ponsun.cms.countryRegistration.domain.CountryRegistration;
import com.ponsun.cms.countryRegistration.domain.CountryRegistrationRepository;
import com.ponsun.cms.countryRegistration.domain.CountryRegistrationRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryRegistrationReadPlatformServiceImpl implements CountryRegistrationReadPlatformService {
    private final CountryRegistrationRepositoryWrapper countryRegistrationRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CountryRegistrationRepository countryRegistrationRepository;
    @Override
    public CountryRegistration fetchCountryRegistrationById(Integer id){
        return this.countryRegistrationRepository.findById(id).get();
    }
    @Override
    public List<CountryRegistration> fetchAllCountryRegistration(){ return this.countryRegistrationRepository.findAll();}
}
