package com.ponsun.cms.countryHq.rowmapper;


import com.ponsun.cms.countryHq.data.CountryHqData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class CountryHqRowMapper implements RowMapper<CountryHqData> {
    private final String schema;
    public CountryHqRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_config_country_hq cd ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cd.id as id, ");
        builder.append("cd.name as name, ");
        builder.append("cd.uid as uid, ");
        builder.append("cd.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public CountryHqData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final String  name = rs.getString("name");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CountryHqData(id,name,uid,euid);
    }
}
