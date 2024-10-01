package com.ponsun.cms.master.gender.rowmapper;

import com.ponsun.cms.master.gender.data.GenderData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class GenderRowMapper implements RowMapper<GenderData> {

    private final String schema;

    public GenderRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_config_gender gender ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("gender.id as id, ");
        builder.append("gender.gender as gender ");
        builder.append(this.schema);
        return builder.toString();
    }


    @Override
    public GenderData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String gender = rs.getString("gender");
        return GenderData.newInstance(id, gender);
    }
}
