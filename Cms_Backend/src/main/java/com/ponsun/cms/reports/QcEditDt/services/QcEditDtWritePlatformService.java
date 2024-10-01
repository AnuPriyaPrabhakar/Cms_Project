package com.ponsun.cms.reports.QcEditDt.services;


import com.ponsun.cms.reports.QcEditDt.data.QcEditDtData;

import java.util.List;

public interface QcEditDtWritePlatformService {
    List<QcEditDtData> fetchAllQcEditDtData(String fromDate, String toDate);
}
