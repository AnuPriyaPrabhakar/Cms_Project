package com.ponsun.cms.commonDetails.services;

import com.ponsun.cms.commonDetails.data.StatusDetailsData;
import com.ponsun.cms.commonDetails.rowmapper.StatusDetailsDTORowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommonDetailsReadServiceImpl implements CommonDetailsReadService {

    private final JdbcTemplate jdbcTemplate;
    private final StatusDetailsDTORowMapper statusDetailsDTORowMapper;
    @Override
    public List<StatusDetailsData> fetchAllData(Integer recordTypeId) {
        final StatusDetailsDTORowMapper rowMapper = new StatusDetailsDTORowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE a.status='A'";

        if (recordTypeId == 0) {
            whereClause += " AND a.recordTypeId=b.id";
            Qry = Qry + whereClause;
            return jdbcTemplate.query(Qry, new Object[]{}, statusDetailsDTORowMapper);
        } else {
            whereClause += " AND a.recordTypeId=b.id AND a.recordTypeId=?";
            Qry = Qry + whereClause;
            return jdbcTemplate.query(Qry, new Object[]{recordTypeId}, statusDetailsDTORowMapper);
        }
    }
}
