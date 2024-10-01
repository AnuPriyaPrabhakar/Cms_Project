package com.ponsun.cms.caseDetails.services;


import com.ponsun.cms.caseDetails.domain.CaseDetails;
import com.ponsun.cms.caseDetails.domain.CaseDetailsRepository;
import com.ponsun.cms.caseDetails.domain.CaseDetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CaseDetailsReadPlatFormServiceImpl implements CaseDetailsReadPlatFormService {

    private final CaseDetailsRepositoryWrapper caseDetailsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CaseDetailsRepository caseDetailsRepository;
    @Override
    public CaseDetails fetchCaseDetailsById(Integer id){
        return this.caseDetailsRepository.findById(id).get();
    }
    @Override
    public List<CaseDetails> fetchAllCaseDetails(){ return this.caseDetailsRepository.findAll();}
}
