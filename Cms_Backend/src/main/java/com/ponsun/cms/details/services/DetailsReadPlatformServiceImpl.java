package com.ponsun.cms.details.services;

import com.ponsun.cms.details.domain.Details;
import com.ponsun.cms.details.domain.DetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class DetailsReadPlatformServiceImpl implements DetailsReadPlatformService {
    private final DetailsRepositoryWrapper detailsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final com.ponsun.cms.details.domain.DetailsRepository DetailsRepository;
    @Override
    public Details fetchDetailsById(Integer id ){
        return this.DetailsRepository.findById(id).get();
    }
    @Override
    public List<Details> fetchAllDetails(){ return this.DetailsRepository.findAll();}
}