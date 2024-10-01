package com.ponsun.cms.master.RelativeConfig.services;


import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.master.RelativeConfig.request.CreateRelativeRequest;
import com.ponsun.cms.master.RelativeConfig.request.UpdateRelativeRequest;

public interface RelativeConfigWritePlatformService {
    Response createRelative(CreateRelativeRequest createRelativeRequest);

    Response updateRelative(Integer id, UpdateRelativeRequest updateRelativeRequest);

    Response deleteRelative(Integer id);
}
