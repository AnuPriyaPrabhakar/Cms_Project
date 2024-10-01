package com.ponsun.cms.taskAssignView.api;

import com.ponsun.cms.taskAssignView.data.TaskAssignViewData;
import com.ponsun.cms.taskAssignView.services.TaskAssignViewWritePlatformService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/TaskAssignView")
public class TaskAssignViewApiResource {
    private final TaskAssignViewWritePlatformService taskAssignViewWritePlatformService;

    public TaskAssignViewApiResource(TaskAssignViewWritePlatformService taskAssignViewWritePlatformService){
        this.taskAssignViewWritePlatformService = taskAssignViewWritePlatformService;
    }

    @GetMapping
    public List<TaskAssignViewData> fetchAll(){
        return this.taskAssignViewWritePlatformService.fetchAllTaskAssignViewData();
    }
}
