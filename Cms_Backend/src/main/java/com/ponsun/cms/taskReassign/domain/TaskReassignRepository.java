package com.ponsun.cms.taskReassign.domain;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskReassignRepository  extends JpaRepository<TaskReassign,Integer> {
    TaskReassign  findBycmsId(Integer cmsId);
}
