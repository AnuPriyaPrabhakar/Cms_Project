package com.ponsun.cms.category.Individual.services;


import com.ponsun.cms.category.Individual.data.IndividualData;
import com.ponsun.cms.category.Individual.rowmapper.IndividualRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class IndividualReaPlatformServiceImpl implements IndividualReaPlatformService {

    private final IndividualRowMapper individualRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<IndividualData> fetchAllIndividualData(String cmsName ) {
        final IndividualRowMapper rowMapper = new IndividualRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = "  WHERE a.uid=c.id AND a.status = 'A' AND b.id = a.recordTypeId AND b.id= 2 AND a.name = ?";
        Qry = Qry + whereClause;
        final List<IndividualData> individualData = jdbcTemplate.query(Qry, individualRowMapper,
                new Object[]{cmsName}
        );
        return individualData;
    }
}



