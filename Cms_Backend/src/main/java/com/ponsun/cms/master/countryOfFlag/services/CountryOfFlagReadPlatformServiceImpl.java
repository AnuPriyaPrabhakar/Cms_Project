package com.ponsun.cms.master.countryOfFlag.services;


import com.ponsun.cms.master.countryOfFlag.domain.CountryOfFlag;
import com.ponsun.cms.master.countryOfFlag.domain.CountryOfFlagRepository;
import com.ponsun.cms.master.countryOfFlag.domain.CountryOfFlagRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryOfFlagReadPlatformServiceImpl implements CountryOfFlagReadPlatformService {

    private final CountryOfFlagRepositoryWrapper countryOfFlagRepositoryWrapper;

    private final JdbcTemplate jdbcTemplate;

    private final CountryOfFlagRepository countryOfFlagRepository;

    @Override
    public CountryOfFlag fetchCountryOfFlagById(Integer id) {
        return this.countryOfFlagRepository.findById(id).get();
    }

    @Override
    public List<CountryOfFlag> fetchAllCountryOfFlag() {
        return this.countryOfFlagRepository.findAll();
    }

}
