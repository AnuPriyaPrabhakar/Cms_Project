package com.ponsun.cms.taskAssign.services;


import com.ponsun.cms.taskAssign.domain.TaskAssign;

import java.util.List;
public interface TaskAssignReadPlatformService {
    TaskAssign fetchTaskAssignById(Integer id);
    List<TaskAssign> fetchAllTaskAssign();
}
