package com.ponsun.cms.master.idNumber.rowmapper;


import com.ponsun.cms.master.idNumber.data.IdNumberData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class IdNumberRowMapper implements RowMapper<IdNumberData> {

    private final String schema;

    public IdNumberRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_config_id_number IdNumber ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("IdNumber.id as id, ");
        builder.append("IdNumber.name as name ");
        builder.append(this.schema);
        return builder.toString();
    }


    @Override
    public IdNumberData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        return IdNumberData.newInstance(id, name);
    }
}
