package com.ponsun.cms.adminconfiguration.adminconfigmoduledet.services;


import com.ponsun.cms.adminconfiguration.adminconfigmoduledet.domain.AdminConfigModuleDet;

import java.util.List;

public interface AdminConfigModuleDetReadPlatformService {

    AdminConfigModuleDet fetchAdminConfigModuleDetById(Integer id);
    List <AdminConfigModuleDet> fetchAllAdminConfigModuleDet();
}
