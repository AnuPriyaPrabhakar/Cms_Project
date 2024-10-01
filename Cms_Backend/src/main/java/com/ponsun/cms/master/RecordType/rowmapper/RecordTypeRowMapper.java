package com.ponsun.cms.master.RecordType.rowmapper;

import com.ponsun.cms.master.RecordType.data.RecordTypeData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class RecordTypeRowMapper implements RowMapper<RecordTypeData> {
    private final String schema;
    public RecordTypeRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_config_record_type rl ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("rl.id as id, ");
        builder.append("rl.name as name, ");
        builder.append("rl.uid as uid, ");
        builder.append("rl.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public RecordTypeData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final String  name = rs.getString("name");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new RecordTypeData(id,name,uid,euid);
    }
}
