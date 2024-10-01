package com.ponsun.cms.countryHq.services;

import com.ponsun.cms.countryHq.domain.CountryHq;

import java.util.List;

public interface CountryHqReadPlatformService {
    CountryHq fetchCountryHqById(Integer id);

    List<CountryHq> fetchAllCountryHq();
}
