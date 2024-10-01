package com.ponsun.cms.master.countryOfBirth.services;

import com.ponsun.cms.master.countryOfBirth.domain.CountryOfBirth;

import java.util.List;

public interface CountryOfBirthReadPlatformService {
    List<CountryOfBirth> fetchAllCountryOfBirth();

    CountryOfBirth fetchCountryOfBirthById(Integer id);
}
