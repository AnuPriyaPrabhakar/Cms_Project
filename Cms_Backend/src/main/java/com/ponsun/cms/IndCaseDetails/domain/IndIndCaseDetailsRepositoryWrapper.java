package com.ponsun.cms.IndCaseDetails.domain;


import com.ponsun.cms.IndCaseDetails.request.AbstractIndCaseDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndIndCaseDetailsRepositoryWrapper extends AbstractIndCaseDetailsRequest {
    private final IndCaseDetailsRepository indCaseDetailsRepository;


    @Transactional
    public IndCaseDetails findOneWithNotFoundDetection(final Integer id){
        return this.indCaseDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CaseDetails Not found" + id));
    }

    @Transactional
    public List<IndCaseDetails> findCmsIdNotFoundDetection(final Integer cmsId){
        return this.indCaseDetailsRepository.findByCmsId(cmsId);
    }

    @Override
    public String toString(){ return super.toString();}
}
