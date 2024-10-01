package com.ponsun.cms.SearchDetails.SearchDetails.services;

import com.ponsun.cms.SearchDetails.SearchDetails.data.SearchDetailsData;

import java.util.List;

public interface SearchDetailsReadPlatformService {
    List<SearchDetailsData> fetchAllSearchDataById(Integer searchId);

}
