package com.ponsun.cms.reports.ManagerPendingDt.services;


import com.ponsun.cms.reports.ManagerPendingDt.data.ManagerPendingDtData;

import java.util.List;

public interface ManagerPendingDtWritePlatformService {
    List<ManagerPendingDtData> fetchAllManagerPendingDtData(String fromDate, String toDate);
}
