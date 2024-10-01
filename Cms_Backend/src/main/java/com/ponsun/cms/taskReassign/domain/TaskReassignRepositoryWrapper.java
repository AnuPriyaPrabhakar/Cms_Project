package com.ponsun.cms.taskReassign.domain;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskReassignRepositoryWrapper {

    private final TaskReassignRepository taskReassignRepository;

    //   @Transactional
//    public TaskReassign findOneWithNotFoundDetection(final Integer id){
//        return this.taskReassignRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Task Not found" + id));
//    }
    @Transactional
    public TaskReassign findOnecmsIdWithNotFoundDetection(final Integer cmsId){
        return this.taskReassignRepository.findBycmsId(cmsId);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
