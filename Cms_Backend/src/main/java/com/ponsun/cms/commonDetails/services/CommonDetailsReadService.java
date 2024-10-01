package com.ponsun.cms.commonDetails.services;

import com.ponsun.cms.commonDetails.data.StatusDetailsData;

import java.util.List;

public interface CommonDetailsReadService {
    List<StatusDetailsData> fetchAllData(Integer recordTypeId);

}
