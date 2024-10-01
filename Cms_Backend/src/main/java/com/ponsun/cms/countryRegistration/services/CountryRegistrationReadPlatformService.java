package com.ponsun.cms.countryRegistration.services;

import com.ponsun.cms.countryRegistration.domain.CountryRegistration;

import java.util.List;

public interface CountryRegistrationReadPlatformService {
    List<CountryRegistration> fetchAllCountryRegistration();

    CountryRegistration fetchCountryRegistrationById(Integer id);
}
