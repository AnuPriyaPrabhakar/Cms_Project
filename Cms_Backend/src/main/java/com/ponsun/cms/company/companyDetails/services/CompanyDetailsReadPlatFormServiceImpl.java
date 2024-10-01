package com.ponsun.cms.company.companyDetails.services;


import com.ponsun.cms.company.companyDetails.domain.CompanyDetails;
import com.ponsun.cms.company.companyDetails.domain.CompanyDetailsRepository;
import com.ponsun.cms.company.companyDetails.domain.CompanyDetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyDetailsReadPlatFormServiceImpl implements CompanyDetailsReadPlatFormService {

    private final CompanyDetailsRepositoryWrapper companyDetailsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CompanyDetailsRepository companyDetailsRepository;
    @Override
    public CompanyDetails fetchCompanyDetailsById(Integer id){
        return this.companyDetailsRepository.findById(id).get();
    }
    @Override
    public List<CompanyDetails> fetchAllCompanyDetails(){ return this.companyDetailsRepository.findAll();}
}
