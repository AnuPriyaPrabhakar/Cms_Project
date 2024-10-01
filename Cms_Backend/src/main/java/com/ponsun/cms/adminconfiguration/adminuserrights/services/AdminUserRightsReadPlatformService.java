package com.ponsun.cms.adminconfiguration.adminuserrights.services;

import com.ponsun.cms.adminconfiguration.adminuserrights.domain.AdminUserRights;

import java.util.List;

public interface AdminUserRightsReadPlatformService {

    AdminUserRights fetchAdminUserRightsById (Integer id);
    List<AdminUserRights> fetchAllAdminUserRights();
}
