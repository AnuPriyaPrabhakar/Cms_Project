package com.ponsun.cms.IndOrg.relationAliases.services;



import com.ponsun.cms.IndOrg.relationAliases.domain.RelationAliases;
import com.ponsun.cms.IndOrg.relationAliases.domain.RelationAliasesRepository;
import com.ponsun.cms.IndOrg.relationAliases.domain.RelationAliasesRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class RelationAliasesReadPlatformServiceImpl implements RelationAliasesReadPlatformService {

    private final RelationAliasesRepositoryWrapper relationAliasesRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final RelationAliasesRepository relationAliasesRepository;
    @Override
    public RelationAliases fetchRelationAliasesById(Integer id){
        return this.relationAliasesRepository.findById(id).get();
    }
    @Override
    public List<RelationAliases> fetchAllRelationAliases(){ return this.relationAliasesRepository.findAll();}
}