package com.ponsun.cms.company.companyAliases.services;



import com.ponsun.cms.company.companyAliases.domain.CompanyAliases;
import com.ponsun.cms.company.companyAliases.domain.CompanyAliasesRepository;
import com.ponsun.cms.company.companyAliases.domain.CompanyAliasesRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyAliasesReadServiceImpl implements CompanyAliasesReadService {

    private final CompanyAliasesRepositoryWrapper companyAliasesRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final CompanyAliasesRepository companyAliasesRepository;
    @Override
    public CompanyAliases fetchCompanyAliasesById(Integer id){
        return this.companyAliasesRepository.findById(id).get();
    }
    @Override
    public List<CompanyAliases> fetchAllCompanyAliases(){ return this.companyAliasesRepository.findAll();}
}
