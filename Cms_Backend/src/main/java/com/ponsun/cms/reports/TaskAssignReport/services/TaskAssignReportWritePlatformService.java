package com.ponsun.cms.reports.TaskAssignReport.services;


import com.ponsun.cms.reports.TaskAssignReport.data.TaskAssignReportData;

import java.util.List;

public interface TaskAssignReportWritePlatformService {
    List<TaskAssignReportData> fetchAllTaskAssignReportData(String fromDate, String toDate);
}
