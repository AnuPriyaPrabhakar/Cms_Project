package com.ponsun.cms.regulator.services;

import com.ponsun.cms.regulator.domain.Regulator;
import com.ponsun.cms.regulator.domain.RegulatorRepository;
import com.ponsun.cms.regulator.domain.RegulatorRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegulatorReadPlatformServiceImpl implements RegulatorReadPlatformService {
    private final RegulatorRepositoryWrapper addressRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final RegulatorRepository regulatorRepository;
    @Override
    public Regulator fetchRegulatorById(Integer id){
        return this.regulatorRepository.findById(id).get();
    }
    @Override
    public List<Regulator> fetchAllRegulator(){ return this.regulatorRepository.findAll();}
}
