package com.ponsun.cms.SearchDetails.Search.services;

import com.ponsun.cms.infrastructure.utils.Response;

import com.ponsun.cms.SearchDetails.Search.request.CreateSearchRequest;

public interface SearchWritePlatformService {
    Response createSearch(CreateSearchRequest createSearchRequest);
}
