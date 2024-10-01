package com.ponsun.cms.userTaskView.services;



import com.ponsun.cms.userTaskView.data.UserTaskViewData;

import java.util.List;

public interface UserTaskViewWritePlatformService {

    List<UserTaskViewData> fetchAllFirstPageData(Integer assignTo);
}
