package com.ponsun.cms.bankDetails.services;


import com.ponsun.cms.bankDetails.domain.BankDetails;
import com.ponsun.cms.bankDetails.domain.BankDetailsRepository;
import com.ponsun.cms.bankDetails.domain.BankDetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankDetailsReadPlatFormServiceImpl implements BankDetailsReadPlatFormService {

    private final BankDetailsRepositoryWrapper bankDetailsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final BankDetailsRepository bankDetailsRepository;
    @Override
    public BankDetails fetchBankDetailsById(Integer id){
        return this.bankDetailsRepository.findById(id).get();
    }
    @Override
    public List<BankDetails> fetchAllBankDetails(){ return this.bankDetailsRepository.findAll();}
}
