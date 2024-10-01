package com.ponsun.cms.reports.PublishedDt.services;


import com.ponsun.cms.reports.PublishedDt.data.PublishedDtData;

import java.util.List;

public interface PublishedDtWritePlatformService {
    List<PublishedDtData> fetchAllPublishedDtData(String fromDate, String toDate);
}
