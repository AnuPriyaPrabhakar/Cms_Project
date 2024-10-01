package com.ponsun.cms.SearchDetails.SearchDetails.services;

import com.ponsun.cms.SearchDetails.SearchDetails.request.CreateSearchDetailsRequest;
import com.ponsun.cms.infrastructure.utils.Response;

public interface SearchDetailsWritePlatformService {
    Response createSearchDetails(CreateSearchDetailsRequest createSearchDetailsRequest);

}
