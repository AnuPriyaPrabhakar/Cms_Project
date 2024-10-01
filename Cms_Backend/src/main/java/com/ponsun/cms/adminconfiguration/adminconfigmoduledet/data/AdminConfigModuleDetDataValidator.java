package com.ponsun.cms.adminconfiguration.adminconfigmoduledet.data;


import com.ponsun.cms.adminconfiguration.adminconfigmoduledet.request.CreateAdminConfigModuleDetRequest;
import com.ponsun.cms.adminconfiguration.adminconfigmoduledet.request.UpdateAdminConfigModuleDetRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminConfigModuleDetDataValidator {
    public void validateSaveModuleDet(final CreateAdminConfigModuleDetRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_CMS_ApplicationException("ModuleName parameter required");
        }
    }
    public void validateUpdateModuleDet(final UpdateAdminConfigModuleDetRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_CMS_ApplicationException("ModuleName parameter required");
        }
    }
}