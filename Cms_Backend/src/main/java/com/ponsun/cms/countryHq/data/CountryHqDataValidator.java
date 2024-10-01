package com.ponsun.cms.countryHq.data;


import com.ponsun.cms.countryHq.request.CreateCountryHqRequest;
import com.ponsun.cms.countryHq.request.UpdateCountryHqRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CountryHqDataValidator {
    public void validateSaveCountryHqData(final CreateCountryHqRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_CMS_ApplicationException("CountryHqId parameter required");
        }
    }
    public void validateUpdateCountryHqData(final UpdateCountryHqRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_CMS_ApplicationException("CountryHqId parameter required");
        }
    }
}
