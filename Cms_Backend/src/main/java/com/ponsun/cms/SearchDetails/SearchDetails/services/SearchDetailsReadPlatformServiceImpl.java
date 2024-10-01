package com.ponsun.cms.SearchDetails.SearchDetails.services;

import com.ponsun.cms.SearchDetails.SearchDetails.data.SearchDetailsData;
import com.ponsun.cms.SearchDetails.SearchDetails.rowmapper.SearchDetailsRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchDetailsReadPlatformServiceImpl implements SearchDetailsReadPlatformService {
    private final JdbcTemplate jdbcTemplate;
    private final SearchDetailsRowMapper searchDetailsRowMapper;

    @Override
    public List<SearchDetailsData> fetchAllSearchDataById(Integer searchId) {

        final SearchDetailsRowMapper rowMapper = new SearchDetailsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE searchId=? ";
        Qry = Qry + whereClause;

        final List<SearchDetailsData> searchDataList=  jdbcTemplate.query(Qry, new Object[]{searchId}, searchDetailsRowMapper);
        return searchDataList;
    }
}
