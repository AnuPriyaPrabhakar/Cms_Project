package com.ponsun.cms.IndOrg.positions.data;

import com.ponsun.cms.IndOrg.positions.request.CreatePositionsRequest;
import com.ponsun.cms.IndOrg.positions.request.UpdatePositionsRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PositionsDataValidator {
    public void validateSavePositionsData(final CreatePositionsRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw new EQAS_CMS_ApplicationException("Id parameter required");
        }
    }
    public void validateUpdatePositionsData(final UpdatePositionsRequest request){
        if(request.getId() == null || request.getId().equals("")){
            throw new EQAS_CMS_ApplicationException("Id parameter required");
        }
    }
}
