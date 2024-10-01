package com.ponsun.cms.accessPermission.services;

import com.ponsun.cms.accessPermission.data.AccessPermissionData;

import java.util.List;

public interface AccessPermissionWritePlatformService {
    List<AccessPermissionData> fetchAllAccessPermissionData(String uid);
}
