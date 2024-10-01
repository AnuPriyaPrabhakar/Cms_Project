package com.ponsun.cms.taskReassign.data;


import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.taskReassign.request.CreateTaskReassignRequest;
import com.ponsun.cms.taskReassign.request.UpdateTaskReassignRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskReassignDataValidator {
    public void validateSaveTaskReassign (final CreateTaskReassignRequest request) {
        if (request.getCmsId() == null || request.getCmsId().equals("")) {
            throw new EQAS_CMS_ApplicationException("cmsId parameter required");
        }
    }
    public void validateUpdateTaskReassign (final UpdateTaskReassignRequest request) {
        if (request.getCmsId() == null || request.getCmsId().equals("")) {
            throw new EQAS_CMS_ApplicationException("cmsId parameter required");


        }
    }}