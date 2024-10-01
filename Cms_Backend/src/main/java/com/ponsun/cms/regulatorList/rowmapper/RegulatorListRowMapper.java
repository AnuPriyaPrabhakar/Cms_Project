package com.ponsun.cms.regulatorList.rowmapper;

import com.ponsun.cms.regulatorList.data.RegulatorListData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class RegulatorListRowMapper implements RowMapper<RegulatorListData> {
    private final String schema;
    public RegulatorListRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_config_regulator_list rl ");
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
    public RegulatorListData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final String  name = rs.getString("name");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new RegulatorListData(id,name,uid,euid);
    }
}
