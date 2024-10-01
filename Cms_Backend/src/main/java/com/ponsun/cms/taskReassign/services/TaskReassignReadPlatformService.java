package com.ponsun.cms.taskReassign.services;


import com.ponsun.cms.taskReassign.domain.TaskReassign;

import java.util.List;

public interface TaskReassignReadPlatformService {

    List<TaskReassign> fetchAllTaskReassign();

    TaskReassign fetchTaskReassignById(Integer id);

    TaskReassign fetchTaskReassignByCmsId(Integer cmsId);

}
