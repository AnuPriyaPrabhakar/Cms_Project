package com.ponsun.cms.requestForUpdate.services;



import com.ponsun.cms.requestForUpdate.domain.RequestForUpdate;

import java.util.List;

public interface RequestForUpdateReadPlatformService {
    List<RequestForUpdate> fetchAllRequestForUpdate();

    RequestForUpdate fetchRequestForUpdateById(Integer id);
}
