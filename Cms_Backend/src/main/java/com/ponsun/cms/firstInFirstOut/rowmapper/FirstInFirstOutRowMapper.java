package com.ponsun.cms.firstInFirstOut.rowmapper;


import com.ponsun.cms.firstInFirstOut.data.FirstInFirstOutData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class FirstInFirstOutRowMapper implements RowMapper<FirstInFirstOutData> {
    private final String schema;
    public FirstInFirstOutRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_details pc ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ccc.id as id");
        builder.append("ccc.recordTypeId as recordTypeId");
        builder.append("ccc.name as name");
        builder.append("ccc.genderId as genderId");
        builder.append("ccc.sourceLink as sourceLink");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public FirstInFirstOutData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final String name = rs.getString("name");
        final Integer genderId = rs.getInt("genderId");
        final String sourceLink = rs.getString("sourceLink");
        return new FirstInFirstOutData (id, recordTypeId, name, genderId, sourceLink);
    }
}
