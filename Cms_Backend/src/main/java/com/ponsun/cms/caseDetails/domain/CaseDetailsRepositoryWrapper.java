package com.ponsun.cms.caseDetails.domain;


import com.ponsun.cms.caseDetails.request.AbstractCaseDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseDetailsRepositoryWrapper extends AbstractCaseDetailsRequest {
    private final CaseDetailsRepository caseDetailsRepository;


    @Transactional
    public CaseDetails findOneWithNotFoundDetection(final Integer id){
        return this.caseDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CaseDetails Not found" + id));
    }

    @Transactional
    public List<CaseDetails> findCmsIdNotFoundDetection(final Integer cmsId){
        return this.caseDetailsRepository.findByCmsId(cmsId);
    }

    @Override
    public String toString(){ return super.toString();}
}
