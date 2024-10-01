package com.ponsun.cms.regulatorList.services;

import com.ponsun.cms.regulatorList.domain.RegulatorList;
import com.ponsun.cms.regulatorList.domain.RegulatorListRepository;
import com.ponsun.cms.regulatorList.domain.RegulatorListRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegulatorListReadPlatformServiceImpl implements RegulatorListReadPlatformService {
    private final RegulatorListRepositoryWrapper regulatorListRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final RegulatorListRepository regulatorListRepository;
    @Override
    public RegulatorList fetchRegulatorListById(Integer id){
        return this.regulatorListRepository.findById(id).get();
    }
    @Override
    public List<RegulatorList> fetchAllRegulatorList(){ return this.regulatorListRepository.findAll();}
}
