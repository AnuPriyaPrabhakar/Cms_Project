package com.ponsun.cms.managerView.services;


import com.ponsun.cms.managerView.data.ManagerViewGetViewData;

import java.util.List;

public interface ManagerViewGetReaPlatformService {
    List<ManagerViewGetViewData> fetchAllManagerViewData(String cmsName);
}
