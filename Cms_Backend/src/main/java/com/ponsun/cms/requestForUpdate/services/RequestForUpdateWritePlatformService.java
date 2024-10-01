package com.ponsun.cms.requestForUpdate.services;


import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.requestForUpdate.request.CreateRequestForUpdateRequest;
import com.ponsun.cms.requestForUpdate.request.UpdateRequestForUpdateRequest;

public interface RequestForUpdateWritePlatformService {
    Response createRequestForUpdateRequest(CreateRequestForUpdateRequest createRequestForUpdateRequest);

    Response updateRequestForUpdate(Integer id, UpdateRequestForUpdateRequest updateRequestForUpdateRequest);
}
