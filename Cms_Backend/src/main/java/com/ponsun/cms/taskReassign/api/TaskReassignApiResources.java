package com.ponsun.cms.taskReassign.api;



import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.taskReassign.domain.TaskReassign;
import com.ponsun.cms.taskReassign.request.CreateTaskReassignRequest;
import com.ponsun.cms.taskReassign.services.TaskReassignReadPlatformService;
import com.ponsun.cms.taskReassign.services.TaskReassignWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/TaskReassign")
@Tag(name = "TaskReassignApiResources")
public class TaskReassignApiResources {

    private final TaskReassignReadPlatformService taskReassignReadPlatformService;
    private final TaskReassignWritePlatformService taskReassignWritePlatformService;


    @PostMapping("/CreateTaskReassign")
    public Response saveTaskReassign(@RequestBody CreateTaskReassignRequest createTaskReassignRequest){
        Response response =this.taskReassignWritePlatformService.createTaskReassign(createTaskReassignRequest);
        return response;
    }
//    @PostMapping("/CreateTask")
//    public Response saveTask(@RequestBody CreateTaskReassignRequest createTaskReassignRequest){
//        Response response =this.taskReassignWritePlatformService.createTaskReassign(createTaskReassignRequest);
//        return response;
//    }
    @GetMapping
    public List<TaskReassign> fetchAll(){
        return this.taskReassignReadPlatformService.fetchAllTaskReassign();
    }

    @GetMapping("/{id}")
    public TaskReassign fetchTaskReassignById(@PathVariable(name = "id") Integer id) {
        return this.taskReassignReadPlatformService.fetchTaskReassignById(id);
    }



    @PutMapping("/{id}/block")
    public Response blockTaskReassign(@PathVariable Integer id) {
        Response response = this.taskReassignWritePlatformService.blockTaskReassign(id);
        return response;
    }

    @PutMapping("/updateEntry/{cmsId}/{uid}/{statusCall}")
    public Response updateEntry(@PathVariable Integer cmsId, Integer uid , String statusCall) {
        Response response = this.taskReassignWritePlatformService.updateEntry(cmsId, uid , statusCall );
        return response;
    }

    @PutMapping("/{id}/unblock")
    public Response unblockTaskReassign(@PathVariable Integer id) {
        Response response = this.taskReassignWritePlatformService.unblockTaskReassign(id);
        return response;
    }

}
