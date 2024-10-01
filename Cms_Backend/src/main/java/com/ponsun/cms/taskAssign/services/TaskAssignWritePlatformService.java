package com.ponsun.cms.taskAssign.services;


import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.taskAssign.request.CreateTaskAssignRequest;
import com.ponsun.cms.taskAssign.request.UpdateTaskAssignRequest;

public interface TaskAssignWritePlatformService {
    Response createTaskAssign(CreateTaskAssignRequest createTaskAssignRequest);
    Response updateTaskAssign(Integer id, UpdateTaskAssignRequest updateTaskAssignRequest);
    Response deactive(Integer id,Integer euid);
//    Response blockTaskAssign(Integer id);
//    Response unblockTaskAssign(Integer id);
}
