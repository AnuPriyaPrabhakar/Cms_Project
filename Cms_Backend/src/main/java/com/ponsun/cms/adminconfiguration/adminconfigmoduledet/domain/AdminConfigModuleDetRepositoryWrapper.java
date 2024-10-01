package com.ponsun.cms.adminconfiguration.adminconfigmoduledet.domain;

import com.ponsun.cms.adminconfiguration.adminconfigmoduledet.request.AbstractAdminConfigModuleDetBaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminConfigModuleDetRepositoryWrapper extends AbstractAdminConfigModuleDetBaseRequest {

    private final AdminConfigModuleDetRepository adminconfigmoduledetRepository;

    @Transactional
    public AdminConfigModuleDet findOneWithNotFoundDetection(final Integer id) {
        return this.adminconfigmoduledetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AdminConfigModuleDet Not found " + id));
    }

//    @Transactional
//    public List<AdminConfigModuleDet> findOnecmsIdWithNotFoundDetection(final Integer cmsId){
//        return this.adminconfigmoduledetRepository.findBycmsId(cmsId);
//    }

    @Override
    public String toString() {
        return super.toString();
    }
}

