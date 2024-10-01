package com.ponsun.cms.allDetails.dateOfBirth.services;

import com.ponsun.cms.allDetails.dateOfBirth.domain.DateOfBirth;
import com.ponsun.cms.allDetails.dateOfBirth.domain.DateOfBirthRepository;
import com.ponsun.cms.allDetails.dateOfBirth.domain.DateOfBirthRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class DateOfBirthReadPlatformServiceImpl implements DateOfBirthReadPlatformService {
    private final DateOfBirthRepositoryWrapper dateOfBirthRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final DateOfBirthRepository dateOfBirthRepository;
    @Override
    public DateOfBirth fetchDateOfBirthById(Integer id){
        return this.dateOfBirthRepository.findById(id).get();
    }
    @Override
    public List<DateOfBirth> fetchAllDateOfBirth(){ return this.dateOfBirthRepository.findAll();}
}