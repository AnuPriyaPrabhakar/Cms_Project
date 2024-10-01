package com.ponsun.cms.category.Ship.services;


import com.ponsun.cms.category.Ship.data.ShipData;
import com.ponsun.cms.category.Ship.rowmapper.ShipRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class ShipReaPlatformServiceImpl implements ShipReaPlatformService {

    private final ShipRowMapper shipRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ShipData> fetchAllShipData(String cmsName ) {
        final ShipRowMapper rowMapper = new ShipRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = "  WHERE a.uid=c.id AND a.status = 'A' AND b.id = a.recordTypeId AND b.id= 3 AND a.name = ?";
        Qry = Qry + whereClause;
        final List<ShipData> shipData = jdbcTemplate.query(Qry, shipRowMapper,
                new Object[]{cmsName}
        );
        return shipData;
    }
}



