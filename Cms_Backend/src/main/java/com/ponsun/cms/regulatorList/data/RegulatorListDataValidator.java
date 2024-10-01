package com.ponsun.cms.regulatorList.data;

import com.ponsun.cms.regulatorList.request.CreateRegulatorListRequest;
import com.ponsun.cms.regulatorList.request.UpdateRegulatorListRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegulatorListDataValidator {
    public void validateSaveRegulatorList(final CreateRegulatorListRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_CMS_ApplicationException("CompanyId parameter required");
        }
    }
    public void validateUpdateRegulatorList(final UpdateRegulatorListRequest request){
        if(request.getUid() == null || request.getUid().equals("")){
            throw new EQAS_CMS_ApplicationException("CompanyId parameter required");
        }
    }
}
