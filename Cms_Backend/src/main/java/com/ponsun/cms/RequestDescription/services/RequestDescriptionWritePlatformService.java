package com.ponsun.cms.RequestDescription.services;


import com.ponsun.cms.RequestDescription.request.CreateRequestDescriptionRequest;
import com.ponsun.cms.RequestDescription.request.UpdateRequestDescriptionRequest;
import com.ponsun.cms.infrastructure.utils.Response;

public interface RequestDescriptionWritePlatformService {
    Response createRequestDescription(CreateRequestDescriptionRequest createRequestDescriptionRequest);
    Response updateRequestDescription(Integer id, UpdateRequestDescriptionRequest updateRequestDescriptionRequest);
    Response blockRequestDescription(Integer id);
    Response unblockRequestDescription(Integer id);
}
