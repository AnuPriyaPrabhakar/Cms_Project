package com.ponsun.cms.adminconfiguration.admingroup.data;


import com.ponsun.cms.adminconfiguration.admingroup.request.CreateAdmingroupRequest;
import com.ponsun.cms.adminconfiguration.admingroup.request.UpdateAdmingroupRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdmingroupDataValidator {
    public void validateSaveAdmingroup(final CreateAdmingroupRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_CMS_ApplicationException("ModuleName parameter required");
        }
    }
    public void validateUpdateAdmingroup(final UpdateAdmingroupRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_CMS_ApplicationException("ModuleName parameter required");
        }
    }
}
