package com.ponsun.cms.adminconfiguration.adminuserrights.data;

import com.ponsun.cms.adminconfiguration.adminuserrights.request.UpdateAdminUserRightsRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminUserRightsDataValidator {
    public void validateSaveAdminUserRights(final AdminUserRightsDTO request) {
        if (request.getModId() == null || request.getModId().equals("")) {
            throw new EQAS_CMS_ApplicationException("AdminminUserRightsModeId parameter required");
        }
        if (request.getModDetId() == null || request.getModDetId().equals("")) {
            throw new EQAS_CMS_ApplicationException("AdminminUserRightsModeDetId parameter required");
        }
    }
    public void validateUpdateAdminUserRights(final UpdateAdminUserRightsRequest request) {
        if (request.getModId() == null || request.getModId().equals("")) {
            throw new EQAS_CMS_ApplicationException("AdminminUserRightsModeId parameter required");
        }
        if (request.getModDetId() == null || request.getModDetId().equals("")) {
            throw new EQAS_CMS_ApplicationException("AdminminUserRightsModeDetId parameter required");
        }
    }
}
