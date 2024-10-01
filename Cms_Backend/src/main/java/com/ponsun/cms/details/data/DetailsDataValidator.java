package com.ponsun.cms.details.data;


import com.ponsun.cms.details.request.CreateDetailsRequest;
import com.ponsun.cms.details.request.UpdateDetailsRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DetailsDataValidator {
    public void validateSaveDetailsData(final CreateDetailsRequest request){
        if(request.getName() == null || request.getName().isEmpty()){
            throw new EQAS_CMS_ApplicationException("Name parameter is required");
        }
    }

    public void validateUpdateDetailsData(final UpdateDetailsRequest request){
        if(request.getName() == null || request.getName().isEmpty()){
            throw new EQAS_CMS_ApplicationException("Name parameter is required");
        }
    }

}
