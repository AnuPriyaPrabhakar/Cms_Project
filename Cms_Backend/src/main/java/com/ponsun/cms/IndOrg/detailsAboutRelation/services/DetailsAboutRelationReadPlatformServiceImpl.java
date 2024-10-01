package com.ponsun.cms.IndOrg.detailsAboutRelation.services;


import com.ponsun.cms.IndOrg.detailsAboutRelation.domain.DetailsAboutRelation;
import com.ponsun.cms.IndOrg.detailsAboutRelation.domain.DetailsAboutRelationRepository;
import com.ponsun.cms.IndOrg.detailsAboutRelation.domain.DetailsAboutRelationRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class DetailsAboutRelationReadPlatformServiceImpl implements DetailsAboutRelationReadPlatformService {

    private final DetailsAboutRelationRepositoryWrapper detailsAboutRelationRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final DetailsAboutRelationRepository detailsAboutRelationRepository;
    @Override
    public DetailsAboutRelation fetchDetailsAboutRelationById(Integer id){
        return this.detailsAboutRelationRepository.findById(id).get();
    }
    @Override
    public List<DetailsAboutRelation> fetchAllDetailsAboutRelation(){ return this.detailsAboutRelationRepository.findAll();}
}