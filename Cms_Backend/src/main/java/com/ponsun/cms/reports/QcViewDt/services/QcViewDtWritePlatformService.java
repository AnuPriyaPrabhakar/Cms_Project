package com.ponsun.cms.reports.QcViewDt.services;


import com.ponsun.cms.reports.QcViewDt.data.QcViewDtData;

import java.util.List;

public interface QcViewDtWritePlatformService {
    List<QcViewDtData> fetchAllQcViewDtData(String fromDate, String toDate);
}
