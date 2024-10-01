package com.ponsun.cms.master.idNumber.services;



import com.ponsun.cms.master.idNumber.domain.IdNumber;
import com.ponsun.cms.master.idNumber.domain.IdNumberRepository;
import com.ponsun.cms.master.idNumber.domain.IdNumberRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IdNumberReadPlatformServiceImpl implements IdNumberReadPlatformService {

    private final IdNumberRepositoryWrapper idNumberRepositoryWrapper;

    private final JdbcTemplate jdbcTemplate;

    private final IdNumberRepository idNumberRepository;

    @Override
    public IdNumber fetchIdNumberById(Integer id) {
        return this.idNumberRepository.findById(id).get();
    }

    @Override
    public List<IdNumber> fetchAllIdNumber() {
        return this.idNumberRepository.findAll();
    }

}
