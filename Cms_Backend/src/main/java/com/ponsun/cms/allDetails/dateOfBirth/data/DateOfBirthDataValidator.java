package com.ponsun.cms.allDetails.dateOfBirth.data;


import com.ponsun.cms.allDetails.dateOfBirth.request.CreateDateOfBirthRequest;
import com.ponsun.cms.allDetails.dateOfBirth.request.UpdateDateOfBirthRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DateOfBirthDataValidator {
    public void validateSaveDateOfBirthData(final CreateDateOfBirthRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
    public void validateUpdateDateOfBirthData(final UpdateDateOfBirthRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
}
