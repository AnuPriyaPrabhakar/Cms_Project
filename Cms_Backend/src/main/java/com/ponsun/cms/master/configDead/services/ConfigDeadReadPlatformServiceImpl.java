package com.ponsun.cms.master.configDead.services;

import com.ponsun.cms.master.configDead.domain.ConfigDead;
import com.ponsun.cms.master.configDead.domain.ConfigDeadRepository;
import com.ponsun.cms.master.configDead.domain.ConfigDeadRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfigDeadReadPlatformServiceImpl implements ConfigDeadReadPlatformService {
    private final ConfigDeadRepositoryWrapper configDeadRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final ConfigDeadRepository configDeadRepository;
    @Override
    public ConfigDead fetchConfigDeadById(Integer id){
        return this.configDeadRepository.findById(id).get();
    }
    @Override
    public List<ConfigDead> fetchAllConfigDead(){ return this.configDeadRepository.findAll();}
}
