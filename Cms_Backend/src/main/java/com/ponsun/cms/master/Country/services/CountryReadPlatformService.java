package com.ponsun.cms.master.Country.services;

import com.ponsun.cms.master.Country.domain.Country;

import java.util.List;

public interface CountryReadPlatformService {

    Country fetchCountryById(Integer id);

    List<Country> fetchAllCountry();
}
