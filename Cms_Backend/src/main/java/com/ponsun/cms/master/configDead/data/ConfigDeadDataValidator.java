package com.ponsun.cms.master.configDead.data;

import com.ponsun.cms.master.configDead.request.CreateConfigDeadRequest;
import com.ponsun.cms.master.configDead.request.UpdateConfigDeadRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConfigDeadDataValidator {
    public void validateSaveConfigDeadData(final CreateConfigDeadRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_CMS_ApplicationException("CompanyId parameter required");
        }
    }
    public void validateUpdateConfigDeadData(final UpdateConfigDeadRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_CMS_ApplicationException("CompanyId parameter required");
        }
    }
}
