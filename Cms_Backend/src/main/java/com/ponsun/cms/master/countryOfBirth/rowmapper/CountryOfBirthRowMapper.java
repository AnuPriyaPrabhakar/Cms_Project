package com.ponsun.cms.master.countryOfBirth.rowmapper;

import com.ponsun.cms.master.countryOfBirth.data.CountryOfBirthData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class CountryOfBirthRowMapper implements RowMapper<CountryOfBirthData> {

    private final String schema;

    public CountryOfBirthRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_config_country_of_birth CountryOfBirth ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("CountryOfBirth.id as id, ");
        builder.append("CountryOfBirth.name as name ");
        builder.append(this.schema);
        return builder.toString();
    }


    @Override
    public CountryOfBirthData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        return CountryOfBirthData.newInstance(id, name);
    }
}
