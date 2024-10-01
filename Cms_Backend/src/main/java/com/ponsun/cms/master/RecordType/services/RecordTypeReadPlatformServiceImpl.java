package com.ponsun.cms.master.RecordType.services;

import com.ponsun.cms.master.RecordType.domain.RecordType;
import com.ponsun.cms.master.RecordType.domain.RecordTypeRepository;
import com.ponsun.cms.master.RecordType.domain.RecordTypeRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecordTypeReadPlatformServiceImpl implements RecordTypeReadPlatformService {
    private final RecordTypeRepositoryWrapper recordTypeRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final RecordTypeRepository recordTypeRepository;
    @Override
    public RecordType fetchRecordTypeById(Integer id){
        return this.recordTypeRepository.findById(id).get();
    }
    @Override
    public List<RecordType> fetchAllRecordType(){ return this.recordTypeRepository.findAll();}
}
