package com.ponsun.cms.adminconfiguration.admingroup.services;


import com.ponsun.cms.adminconfiguration.admingroup.request.CreateAdmingroupRequest;
import com.ponsun.cms.adminconfiguration.admingroup.request.UpdateAdmingroupRequest;
import com.ponsun.cms.infrastructure.utils.Response;

public interface AdmingroupWritePlatformService {

    Response createAdmingroup(CreateAdmingroupRequest createAdmingroupRequest);
    Response updateAdmingroup(Integer id, UpdateAdmingroupRequest updateAdmingroupRequest);
    Response blockAdmingroup(Integer id);
    Response unblockAdmingroup(Integer id);


}
