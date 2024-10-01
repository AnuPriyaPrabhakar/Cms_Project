package com.ponsun.cms.category.Aircraft.services;


import com.ponsun.cms.category.Aircraft.data.AircraftData;
import com.ponsun.cms.category.Aircraft.rowmapper.AircraftRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class AircraftReaPlatformServiceImpl implements AircraftReaPlatformService {

    private final AircraftRowMapper aircraftRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<AircraftData> fetchAllAircraftData(String cmsName ) {
        final AircraftRowMapper rowMapper = new AircraftRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = "  WHERE a.uid=c.id AND a.status = 'A' AND b.id = a.recordTypeId AND b.id= 4 AND a.name = ?";
        Qry = Qry + whereClause;
        final List<AircraftData> aircraftData = jdbcTemplate.query(Qry, aircraftRowMapper,
                new Object[]{cmsName}
        );
        return aircraftData;
    }
}



