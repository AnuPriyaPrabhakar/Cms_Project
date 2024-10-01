package com.ponsun.cms.allDetails.aliases.services;

import com.ponsun.cms.allDetails.aliases.domain.Aliases;
import com.ponsun.cms.allDetails.aliases.domain.AliasesRepository;
import com.ponsun.cms.allDetails.aliases.domain.AliasesRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class AliasesReadPlatformServiceImpl implements AliasesReadPlatformService {
    private final AliasesRepositoryWrapper aliasesRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AliasesRepository aliasesRepository;

    @Override
    public Aliases fetchAliasesById(Integer id){ return this.aliasesRepository.findById(id).get();}
    @Override
    public List<Aliases> fetchAllAliases(){ return this.aliasesRepository.findAll();}
}
