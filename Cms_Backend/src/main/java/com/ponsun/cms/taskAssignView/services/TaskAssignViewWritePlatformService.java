package com.ponsun.cms.taskAssignView.services;


import com.ponsun.cms.taskAssignView.data.TaskAssignViewData;

import java.util.List;

public interface TaskAssignViewWritePlatformService {
    List<TaskAssignViewData> fetchAllTaskAssignViewData();
}
