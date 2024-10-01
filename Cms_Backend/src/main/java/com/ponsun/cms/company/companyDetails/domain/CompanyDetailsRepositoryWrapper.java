package com.ponsun.cms.company.companyDetails.domain;


import com.ponsun.cms.company.companyDetails.request.AbstractCompanyDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyDetailsRepositoryWrapper extends AbstractCompanyDetailsRequest {
    private final CompanyDetailsRepository companyDetailsRepository;


    @Transactional
    public CompanyDetails findOneWithNotFoundDetection(final Integer id){
        return this.companyDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BankDetails Not found" + id));
    }

    @Transactional
    public List<CompanyDetails> findCmsIdNotFoundDetection(final Integer cmsId){
        return this.companyDetailsRepository.findByCmsId(cmsId);
    }

    @Override
    public String toString(){ return super.toString();}
}
