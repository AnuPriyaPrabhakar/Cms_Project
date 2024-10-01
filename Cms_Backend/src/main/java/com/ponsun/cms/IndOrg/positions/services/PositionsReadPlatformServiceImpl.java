package com.ponsun.cms.IndOrg.positions.services;


import com.ponsun.cms.IndOrg.positions.domain.Positions;
import com.ponsun.cms.IndOrg.positions.domain.PositionsRepository;
import com.ponsun.cms.IndOrg.positions.domain.PositionsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class PositionsReadPlatformServiceImpl implements PositionsReadPlatformService {

    private final PositionsRepositoryWrapper positionsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final PositionsRepository positionsRepository;
    @Override
    public Positions fetchPositionsById(Integer id){
        return this.positionsRepository.findById(id).get();
    }
    @Override
    public List<Positions> fetchAllPositions(){ return this.positionsRepository.findAll();}
}