package com.ponsun.cms.reports.ReassignDt.services;


import com.ponsun.cms.reports.ReassignDt.data.ReassignDtData;

import java.util.List;

public interface ReassignDtWritePlatformService {
    List<ReassignDtData> fetchAllReassignDtData(String fromDate, String toDate);
}
