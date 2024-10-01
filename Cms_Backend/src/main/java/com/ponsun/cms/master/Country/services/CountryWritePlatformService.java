package com.ponsun.cms.master.Country.services;

import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.master.Country.request.CreateCountryRequest;
import com.ponsun.cms.master.Country.request.UpdateCountryRequest;

public interface CountryWritePlatformService {
    Response createCountry(CreateCountryRequest createCountryRequest);
    Response updateCountry(Integer id, UpdateCountryRequest updateCountryRequest);
    Response blockCountry(Integer id);
    Response unblockCountry(Integer id);

}
