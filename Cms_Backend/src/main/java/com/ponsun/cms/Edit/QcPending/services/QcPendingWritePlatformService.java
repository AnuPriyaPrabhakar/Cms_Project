package com.ponsun.cms.Edit.QcPending.services;

import com.ponsun.cms.Edit.QcPending.data.QcPendingData;

import java.util.List;

public interface QcPendingWritePlatformService {

    List<QcPendingData> fetchAllQcPendingData(String fromDate, String toDate);
}
