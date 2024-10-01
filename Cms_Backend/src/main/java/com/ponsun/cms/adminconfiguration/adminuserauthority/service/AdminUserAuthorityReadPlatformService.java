package com.ponsun.cms.adminconfiguration.adminuserauthority.service;


import com.ponsun.cms.adminconfiguration.adminuserauthority.domain.AdminUserAuthority;

import java.util.List;

public interface AdminUserAuthorityReadPlatformService {
    AdminUserAuthority fetchAdminUserAuthorityById (Integer id);
    List<AdminUserAuthority> fetchAllAdminUserAuthority();
}
