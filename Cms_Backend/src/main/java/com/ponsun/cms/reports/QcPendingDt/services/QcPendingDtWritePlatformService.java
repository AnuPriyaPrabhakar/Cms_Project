package com.ponsun.cms.reports.QcPendingDt.services;


import com.ponsun.cms.reports.QcPendingDt.data.QcPendingDtData;

import java.util.List;

public interface QcPendingDtWritePlatformService {
    List<QcPendingDtData> fetchAllQcPendingDtData(String fromDate, String toDate);
}
