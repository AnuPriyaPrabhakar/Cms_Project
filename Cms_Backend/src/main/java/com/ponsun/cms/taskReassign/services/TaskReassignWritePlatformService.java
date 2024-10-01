package com.ponsun.cms.taskReassign.services;


import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.taskReassign.request.CreateTaskReassignRequest;

public interface TaskReassignWritePlatformService {

   Response createTaskReassign(CreateTaskReassignRequest createTaskReassignRequest);
    Response createTaskAssign(Integer cmsId,Integer uid);
    Response updateEntry(Integer cmsId, Integer uid, String statusCall);
    // Response updateTaskReassign(Integer id, UpdateTaskReassignRequest updateTaskReassignRequest);

    Response blockTaskReassign(Integer id);

    Response unblockTaskReassign(Integer id);
}
