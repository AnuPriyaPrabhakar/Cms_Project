package com.ponsun.cms.taskReassign.services;


import com.ponsun.cms.taskReassign.domain.TaskReassign;
import com.ponsun.cms.taskReassign.domain.TaskReassignRepository;
import com.ponsun.cms.taskReassign.domain.TaskReassignRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskReassignReadPlatformServiceImpl implements TaskReassignReadPlatformService {

    private final TaskReassignRepositoryWrapper taskReassignRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final TaskReassignRepository taskReassignRepository;

    @Override
    public TaskReassign fetchTaskReassignById(Integer id) {

        return this.taskReassignRepository.findById(id).get();
    }

    @Override
    public TaskReassign fetchTaskReassignByCmsId(Integer cmsId) {
        return this.taskReassignRepository.findById(cmsId).get();
    }

    @Override
    public List<TaskReassign> fetchAllTaskReassign() {
        return this.taskReassignRepository.findAll();
    }
}

