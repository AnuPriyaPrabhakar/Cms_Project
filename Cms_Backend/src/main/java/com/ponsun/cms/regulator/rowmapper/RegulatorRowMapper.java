package com.ponsun.cms.regulator.rowmapper;

import com.ponsun.cms.regulator.data.RegulatorData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class RegulatorRowMapper implements RowMapper<RegulatorData> {
    private final String schema;
    public RegulatorRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_config_regulator cr ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cr.id as id, ");
        builder.append("cr.regulator as regulator, ");
        builder.append("cr.uid as uid, ");
        builder.append("cr.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public RegulatorData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final String  Regulator = rs.getString("regulator");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new RegulatorData(id,Regulator,uid,euid);
    }
}
