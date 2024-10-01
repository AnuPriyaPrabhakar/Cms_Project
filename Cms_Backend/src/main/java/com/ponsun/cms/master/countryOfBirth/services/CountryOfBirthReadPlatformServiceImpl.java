package com.ponsun.cms.master.countryOfBirth.services;

import com.ponsun.cms.master.countryOfBirth.domain.CountryOfBirthRepositoryWrapper;
import com.ponsun.cms.master.countryOfBirth.domain.CountryOfBirth;
import com.ponsun.cms.master.countryOfBirth.domain.CountryOfBirthRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryOfBirthReadPlatformServiceImpl implements CountryOfBirthReadPlatformService {

    private final CountryOfBirthRepositoryWrapper CountryOfBirthRepositoryWrapper;

    private final JdbcTemplate jdbcTemplate;

    private final CountryOfBirthRepository countryOfBirthRepository;

    @Override
    public CountryOfBirth fetchCountryOfBirthById(Integer id) {
        return this.countryOfBirthRepository.findById(id).get();
    }

    @Override
    public List<CountryOfBirth> fetchAllCountryOfBirth() {
        return this.countryOfBirthRepository.findAll();
    }

}
