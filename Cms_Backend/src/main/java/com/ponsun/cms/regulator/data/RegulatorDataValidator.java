package com.ponsun.cms.regulator.data;

import com.ponsun.cms.regulator.request.CreateRegulatorRequest;
import com.ponsun.cms.regulator.request.UpdateRegulatorRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegulatorDataValidator {
    public void validateSaveRegulatorData(final CreateRegulatorRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_CMS_ApplicationException("CompanyId parameter required");
        }
    }
    public void validateUpdateRegulatorData(final UpdateRegulatorRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_CMS_ApplicationException("CompanyId parameter required");
        }
    }
}
