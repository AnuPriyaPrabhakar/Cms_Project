package com.ponsun.cms.firstInFirstOut.services;

import com.ponsun.cms.firstInFirstOut.data.FirstInFirstOutData;
import com.ponsun.cms.firstInFirstOut.rowmapper.FirstInFirstOutRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class FirstInFirstOutReadPlatformServiceImpl implements FirstInFirstOutReadPlatformService {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<FirstInFirstOutData> getAllCustomersOrderedByIdDesc() {
        String sql = "SELECT * FROM cms_details ORDER BY id DESC";
        return jdbcTemplate.query(sql, new FirstInFirstOutRowMapper());
    }
}

