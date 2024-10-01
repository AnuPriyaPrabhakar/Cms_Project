package com.ponsun.cms.IndOrg.relation.services;



import com.ponsun.cms.IndOrg.relation.domain.Relation;
import com.ponsun.cms.IndOrg.relation.domain.RelationRepository;
import com.ponsun.cms.IndOrg.relation.domain.RelationRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class RelationReadPlatformServiceImpl implements RelationReadPlatformService {

    private final RelationRepositoryWrapper relationRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final RelationRepository relationRepository;
    @Override
    public Relation fetchRelationsById(Integer id){
        return this.relationRepository.findById(id).get();
    }
    @Override
    public List<Relation> fetchAllRelations(){ return this.relationRepository.findAll();}
}