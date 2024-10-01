package com.ponsun.cms.IndPositions.services;



import com.ponsun.cms.IndPositions.domain.IndPositions;
import com.ponsun.cms.IndPositions.domain.IndPositionsRepository;
import com.ponsun.cms.IndPositions.domain.IndPositionsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class IndPositionsReadPlatformServiceImpl implements IndPositionsReadPlatformService {

    private final IndPositionsRepositoryWrapper indPositionsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final IndPositionsRepository indPositionsRepository;
    @Override
    public IndPositions fetchIndPositionsById(Integer id){
        return this.indPositionsRepository.findById(id).get();
    }
    @Override
    public List<IndPositions> fetchAllIndPositions(){ return this.indPositionsRepository.findAll();}
}