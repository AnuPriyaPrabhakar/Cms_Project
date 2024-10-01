package com.ponsun.cms.adminconfiguration.admingroup.services;


import com.ponsun.cms.adminconfiguration.admingroup.domain.Admingroup;

import java.util.List;

public interface AdmingroupReadPlatformService {
    Admingroup fetchAdmingroupById(Integer id);
    List<Admingroup> fetchAllAdmingroup();



}