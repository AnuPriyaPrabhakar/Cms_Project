package com.ponsun.cms.master.Country.data;

import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.master.Country.request.CreateCountryRequest;
import com.ponsun.cms.master.Country.request.UpdateCountryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CountryDataValidator {
    public void validateSaveCountry(final CreateCountryRequest request){
        if (request.getName()== null || request.getName().equals("")){
            throw new EQAS_CMS_ApplicationException("name parameter required");
        }
    }
    public void validateUpdateCountry(final UpdateCountryRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_CMS_ApplicationException("name parameter required");


        }
    }
}
