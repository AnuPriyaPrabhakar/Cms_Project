package com.ponsun.cms.company.companyAliases.domain;


import com.ponsun.cms.company.companyAliases.request.AbstractCompanyAliasesRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyAliasesRepositoryWrapper extends AbstractCompanyAliasesRequest {
    private final CompanyAliasesRepository CompanyAliasesRepository;


    @Transactional
    public CompanyAliases findOneWithNotFoundDetection(final Integer id){
        return this.CompanyAliasesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Company Aliases Not found" + id));
    }

    @Transactional
    public List<CompanyAliases> findCmsIdNotFoundDetection(final Integer cmsId){
        return this.CompanyAliasesRepository.findByCmsId(cmsId);
    }

    @Override
    public String toString(){ return super.toString();}
}
