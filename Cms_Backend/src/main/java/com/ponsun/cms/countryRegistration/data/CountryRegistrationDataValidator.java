package com.ponsun.cms.countryRegistration.data;


import com.ponsun.cms.countryRegistration.request.CreateCountryRegistrationRequest;
import com.ponsun.cms.countryRegistration.request.UpdateCountryRegistrationRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CountryRegistrationDataValidator {
    public void validateSaveCountryRegistrationData(final CreateCountryRegistrationRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
    public void validateUpdateCountryRegistrationData(final UpdateCountryRegistrationRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
}
