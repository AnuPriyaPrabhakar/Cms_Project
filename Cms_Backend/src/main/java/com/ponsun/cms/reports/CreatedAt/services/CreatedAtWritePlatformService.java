package com.ponsun.cms.reports.CreatedAt.services;


import com.ponsun.cms.reports.CreatedAt.data.CreatedAtData;

import java.util.List;

public interface CreatedAtWritePlatformService {

    List<CreatedAtData> fetchAllCreatedAtData(String fromDate, String toDate);
}
