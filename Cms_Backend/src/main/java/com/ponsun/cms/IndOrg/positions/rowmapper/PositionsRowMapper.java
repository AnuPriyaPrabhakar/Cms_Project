package com.ponsun.cms.IndOrg.positions.rowmapper;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.PositionsDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class PositionsRowMapper implements RowMapper<PositionsDTO> {
    private final String schema;
    public PositionsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_position position ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("position.id as id, ");
        builder.append("position.cmsId as cmsId, ");
        builder.append("position.recordTypeId as recordTypeId, ");
        builder.append("position.position as position,");
        builder.append("position.linIndName as linIndName,");
        builder.append("position.uid as uid, ");
        builder.append("position.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public PositionsDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer cmsId = rs.getInt("cmsId");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final String position = rs.getString("position");
        final String linIndName = rs.getString("linIndName");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new PositionsDTO (id, cmsId, recordTypeId, position, linIndName,uid,euid);
    }
}
