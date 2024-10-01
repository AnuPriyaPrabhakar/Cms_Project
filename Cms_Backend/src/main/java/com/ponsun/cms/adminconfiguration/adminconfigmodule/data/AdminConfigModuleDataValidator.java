package com.ponsun.cms.adminconfiguration.adminconfigmodule.data;


import com.ponsun.cms.adminconfiguration.adminconfigmodule.request.CreateAdminConfigModuleRequest;
import com.ponsun.cms.adminconfiguration.adminconfigmodule.request.UpdateAdminConfigModuleRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminConfigModuleDataValidator {
    public void validateSaveAdminConfigModule(final CreateAdminConfigModuleRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_CMS_ApplicationException("AdminConfigModuleName parameter required");
        }
    }
    public void validateUpdateAdminConfigModule(final UpdateAdminConfigModuleRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_CMS_ApplicationException("AdminConfigModuleName parameter required");
        }
    }
}
