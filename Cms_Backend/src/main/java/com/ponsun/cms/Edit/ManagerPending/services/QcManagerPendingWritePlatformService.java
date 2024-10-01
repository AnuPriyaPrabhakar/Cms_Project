package com.ponsun.cms.Edit.ManagerPending.services;


import com.ponsun.cms.Edit.Manager.data.QcManagerPendingData;

import java.util.List;

public interface QcManagerPendingWritePlatformService {

    List<QcManagerPendingData> fetchAllQcManagerPendingData(String fromDate, String toDate);
}
