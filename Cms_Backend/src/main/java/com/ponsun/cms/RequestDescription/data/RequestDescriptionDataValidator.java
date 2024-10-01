package com.ponsun.cms.RequestDescription.data;


import com.ponsun.cms.RequestDescription.request.CreateRequestDescriptionRequest;
import com.ponsun.cms.RequestDescription.request.UpdateRequestDescriptionRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RequestDescriptionDataValidator {
    public void validateSaveRequestDescription(final CreateRequestDescriptionRequest request){
        if(request.getDescription() == null || request.getDescription().equals("")){
            throw new EQAS_CMS_ApplicationException("description parameter required");
        }
    }
    public void validateUpdateRequestDescription(final UpdateRequestDescriptionRequest request){
        if(request.getDescription() == null || request.getDescription().equals("")){
            throw new EQAS_CMS_ApplicationException("description parameter required");
        }
    }
}
