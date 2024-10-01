package com.ponsun.cms.adminconfiguration.adminuserauthority.service;


import com.ponsun.cms.adminconfiguration.adminuserauthority.request.CreateAdminUserAuthorityRequest;
import com.ponsun.cms.adminconfiguration.adminuserauthority.request.UpdateAdminUserAuthorityRequest;
import com.ponsun.cms.infrastructure.utils.Response;

public interface AdminUserAuthorityWritePlatformService {
    Response createAdminUserAuthority(CreateAdminUserAuthorityRequest createAdminUserAuthorityRequest);
    Response updateAdminUserAuthority(Integer id, UpdateAdminUserAuthorityRequest updateAdminUserAuthorityRequest);
    Response blockAdminUserAuthority(Integer id);
    Response unblockAdminUserAuthority(Integer id);
}
