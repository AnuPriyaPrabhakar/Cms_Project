package com.ponsun.cms.IndCaseDetails.services;


import com.ponsun.cms.IndCaseDetails.domain.IndCaseDetails;
import com.ponsun.cms.IndCaseDetails.domain.IndCaseDetailsRepository;
import com.ponsun.cms.IndCaseDetails.domain.IndIndCaseDetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndCaseDetailsReadPlatFormServiceImpl implements IndCaseDetailsReadPlatFormService {

    private final IndIndCaseDetailsRepositoryWrapper indCaseDetailsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final IndCaseDetailsRepository indCaseDetailsRepository;
    @Override
    public IndCaseDetails fetchCaseDetailsById(Integer id){
        return this.indCaseDetailsRepository.findById(id).get();
    }
    @Override
    public List<IndCaseDetails> fetchAllCaseDetails(){ return this.indCaseDetailsRepository.findAll();}
}
