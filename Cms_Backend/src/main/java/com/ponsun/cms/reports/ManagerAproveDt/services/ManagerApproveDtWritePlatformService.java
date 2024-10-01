package com.ponsun.cms.reports.ManagerAproveDt.services;


import com.ponsun.cms.reports.ManagerAproveDt.data.ManagerApproveDtData;

import java.util.List;

public interface ManagerApproveDtWritePlatformService {
    List<ManagerApproveDtData> fetchAllManagerApproveDtData(String fromDate, String toDate);
}
