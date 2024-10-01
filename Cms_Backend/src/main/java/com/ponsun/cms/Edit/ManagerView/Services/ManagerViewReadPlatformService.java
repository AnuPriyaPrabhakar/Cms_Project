package com.ponsun.cms.Edit.ManagerView.Services;


import com.ponsun.cms.Edit.ManagerView.data.ManagerViewData;

import java.util.List;

public interface ManagerViewReadPlatformService {

    List<ManagerViewData> fetchAllManagerViewData(String fromDate, String toDate);
}
