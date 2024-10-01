package com.ponsun.cms.adminconfiguration.adminconfigmodule.services;


import com.ponsun.cms.adminconfiguration.adminconfigmodule.domain.AdminConfigModule;

import java.util.List;

public interface AdminConfigModuleReadPlatformService {
    AdminConfigModule fetchAdminConfigModuleById(Integer id);
    List<AdminConfigModule> fetchAllAdminConfigModule();
}