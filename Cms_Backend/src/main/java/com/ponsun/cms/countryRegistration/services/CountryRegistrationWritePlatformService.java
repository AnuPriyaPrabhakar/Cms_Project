package com.ponsun.cms.countryRegistration.services;

import com.ponsun.cms.countryRegistration.data.CountryRegistrationData;
import com.ponsun.cms.countryRegistration.request.CreateCountryRegistrationRequest;
import com.ponsun.cms.countryRegistration.request.UpdateCountryRegistrationRequest;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CountryRegistrationWritePlatformService {
    Response createCountryRegistration(CreateCountryRegistrationRequest createCountryRegistrationRequest);

    Response updateCountryRegistration(Integer id, UpdateCountryRegistrationRequest updateAliasesNameRequest);

    List<CountryRegistrationData> fetchAllCountryRegistrationData(Integer cmsId);
    
    Response    deactive(Integer cmsId, Integer euid);
}
