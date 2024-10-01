package com.ponsun.cms.countryHq.services;

import com.ponsun.cms.countryHq.request.CreateCountryHqRequest;
import com.ponsun.cms.countryHq.request.UpdateCountryHqRequest;
import com.ponsun.cms.infrastructure.utils.Response;

public interface CountryHqWritePlatformService {
    Response createCountryHq(CreateCountryHqRequest createCountryHqRequest);

    Response updateCountryHq(Integer id, UpdateCountryHqRequest updateAliasesNameRequest);
}
