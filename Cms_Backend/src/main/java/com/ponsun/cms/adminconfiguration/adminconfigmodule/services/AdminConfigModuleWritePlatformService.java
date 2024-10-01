package com.ponsun.cms.adminconfiguration.adminconfigmodule.services;


import com.ponsun.cms.adminconfiguration.adminconfigmodule.request.CreateAdminConfigModuleRequest;
import com.ponsun.cms.adminconfiguration.adminconfigmodule.request.UpdateAdminConfigModuleRequest;
import com.ponsun.cms.infrastructure.utils.Response;

public interface AdminConfigModuleWritePlatformService {
    Response createAdminConfigModule(CreateAdminConfigModuleRequest createAdminConfigModuleRequest);
    Response updateAdminConfigModule(Integer id, UpdateAdminConfigModuleRequest updateAdminConfigModuleRequest);

    Response deactive(Integer id, Integer euid);

    Response blockAdminConfigModule(Integer id);
    Response unblockAdminConfigModule(Integer id);
}