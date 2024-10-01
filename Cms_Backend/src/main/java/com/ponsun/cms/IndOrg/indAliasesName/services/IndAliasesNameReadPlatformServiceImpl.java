package com.ponsun.cms.IndOrg.indAliasesName.services;


import com.ponsun.cms.IndOrg.indAliasesName.domain.IndAliasesName;
import com.ponsun.cms.IndOrg.indAliasesName.domain.IndAliasesNameRepository;
import com.ponsun.cms.IndOrg.indAliasesName.domain.IndAliasesNameRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class IndAliasesNameReadPlatformServiceImpl implements IndAliasesNameReadPlatformService {

    private final IndAliasesNameRepositoryWrapper indAliasesNameRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final IndAliasesNameRepository indAliasesNameRepository;
    @Override
    public IndAliasesName fetchIndAliasesNameById(Integer id){
        return this.indAliasesNameRepository.findById(id).get();
    }
    @Override
    public List<IndAliasesName> fetchAllIndAliasesName(){ return this.indAliasesNameRepository.findAll();}
}