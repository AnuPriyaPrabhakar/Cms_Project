package com.ponsun.cms.Edit.ManagerViewPending.services;


import com.ponsun.cms.Edit.ManagerViewPending.data.ManagerViewPendingData;

import java.util.List;

public interface ManagerViewPendingReadPlatformService {

    List<ManagerViewPendingData> fetchAllManagerViewPendingData(String fromDate, String toDate);
}
