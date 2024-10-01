package com.ponsun.cms.master.configDead.rowmapper;

import com.ponsun.cms.master.configDead.data.ConfigDeadData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class ConfigDeadRowMapper implements RowMapper<ConfigDeadData> {
    private final String schema;
    public ConfigDeadRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_config_dead cd ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cd.id as id, ");
        builder.append("cd.configDead as configDead, ");
        builder.append("cd.uid as uid, ");
        builder.append("cd.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public ConfigDeadData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final String  ConfigDead = rs.getString("configDead");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new ConfigDeadData(id,ConfigDead,uid,euid);
    }
}
