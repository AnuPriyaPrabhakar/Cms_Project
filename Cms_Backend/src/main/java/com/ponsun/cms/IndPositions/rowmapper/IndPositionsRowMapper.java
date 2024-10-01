package com.ponsun.cms.IndPositions.rowmapper;


import com.ponsun.cms.IndPositions.data.IndPositionsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class IndPositionsRowMapper implements RowMapper<IndPositionsData> {
    private final String schema;
    public IndPositionsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_individual_position ip ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ip.cmsId as cmsId, ");
        builder.append("ip.recordTypeId as recordTypeId, ");
        builder.append("ip.position as position,");
        builder.append("ip.uid as uid, ");
        builder.append("ip.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public IndPositionsData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer cmsId = rs.getInt("cmsId");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final String position = rs.getString("position");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new IndPositionsData(cmsId, recordTypeId, position,uid,euid);
    }
}
