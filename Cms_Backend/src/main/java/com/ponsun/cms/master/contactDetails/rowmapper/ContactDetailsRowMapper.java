package com.ponsun.cms.master.contactDetails.rowmapper;


import com.ponsun.cms.master.contactDetails.data.ContactDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class ContactDetailsRowMapper implements RowMapper<ContactDetailsData> {

    private final String schema;

    public ContactDetailsRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_config_contact contact ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" contact.id as id, ");
        builder.append(" contact.name as name ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ContactDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        return ContactDetailsData.newInstance(id, name);
    }
}
