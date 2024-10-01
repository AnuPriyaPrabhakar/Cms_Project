package com.ponsun.cms.master.countryOfFlag.rowmpper;


import com.ponsun.cms.master.countryOfFlag.data.CountryOfFlagData;
import com.ponsun.cms.master.countryOfFlag.domain.CountryOfFlag;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class CountryOfFlagRowMapper implements RowMapper<CountryOfFlagData> {

    private final String schema;

    public CountryOfFlagRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_config_country_of_flag CountryOfFlag ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("CountryOfFlag.id as id, ");
        builder.append("CountryOfFlag.name as name ");
        builder.append(this.schema);
        return builder.toString();
    }


    @Override
    public CountryOfFlagData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        return CountryOfFlagData.newInstance(id, name);
    }
}
