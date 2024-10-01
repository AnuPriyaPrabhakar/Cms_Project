package com.ponsun.cms.taskAssign.data;


import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.taskAssign.request.CreateTaskAssignRequest;
import com.ponsun.cms.taskAssign.request.UpdateTaskAssignRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskAssignDataValidator {
    public void validateSaveTaskAssign(final CreateTaskAssignRequest request){
        if(request.getAssignTo() == null || request.getAssignTo().equals("")){
            throw  new EQAS_CMS_ApplicationException("TaskAssignTo parameter required");
        }
        if(request.getAssignBy() == null || request.getAssignBy().equals("")){
            throw new EQAS_CMS_ApplicationException("TaskAssignBy parameter required");
        }
    }

    public void validateUpdateTaskAssign(final UpdateTaskAssignRequest request){
        if(request.getAssignTo() == null || request.getAssignTo().equals("")){
            throw new EQAS_CMS_ApplicationException("TaskAssignTo parameter required");
        }
        if(request.getAssignBy() == null || request.getAssignBy().equals("")){
            throw new EQAS_CMS_ApplicationException("TaskAssignBy parameter required");
        }
    }
}
