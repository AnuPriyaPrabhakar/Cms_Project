package com.ponsun.cms.master.countryOfFlag.services;

import com.ponsun.cms.master.countryOfFlag.domain.CountryOfFlag;

import java.util.List;

public interface CountryOfFlagReadPlatformService {
    List<CountryOfFlag> fetchAllCountryOfFlag();

    CountryOfFlag fetchCountryOfFlagById(Integer id);
}
