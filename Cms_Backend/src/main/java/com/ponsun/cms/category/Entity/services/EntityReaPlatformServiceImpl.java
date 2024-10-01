package com.ponsun.cms.category.Entity.services;


import com.ponsun.cms.category.Entity.data.EntityData;
import com.ponsun.cms.category.Entity.rowmapper.EntityRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class EntityReaPlatformServiceImpl implements EntityReaPlatformService {

    private final EntityRowMapper entityRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<EntityData> fetchAllEntityData(String cmsName ) {
        final EntityRowMapper rowMapper = new EntityRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = "  WHERE a.uid=c.id AND a.status = 'A' AND b.id = a.recordTypeId AND b.id= 1 AND a.name = ?";
        Qry = Qry + whereClause;
        final List<EntityData> entityData = jdbcTemplate.query(Qry, entityRowMapper,
                new Object[]{cmsName}
        );
        return entityData;
    }
}



