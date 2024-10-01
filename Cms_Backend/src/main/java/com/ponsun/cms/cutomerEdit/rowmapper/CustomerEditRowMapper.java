package com.ponsun.cms.cutomerEdit.rowmapper;


import com.ponsun.cms.cutomerEdit.data.CustomerEditData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j

public class CustomerEditRowMapper implements RowMapper<CustomerEditData> {

    private final String schema;

    public CustomerEditRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_details a , admin_users b  ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.id AS cmsId , a.name , a.recordTypeId ,b.full_name AS userName, a.created_at , a.genderId ,a.uid , a.sourceLink");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public CustomerEditData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer cmsId = rs.getInt("cmsId");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final String name = rs.getString("name");
        final String sourceLink = rs.getString("sourceLink");
        final String frmDate = "";//rs.getString("frmDate");
        final String toDate = "";//rs.getString("toDate");
        final Integer genderId = rs.getInt("genderId");
        final Integer uid = rs.getInt("uid");
        final String created_at = rs.getString("created_at");
        final String userName = rs.getString("userName");

        return new CustomerEditData(cmsId, recordTypeId, name, sourceLink,frmDate , toDate, genderId, uid, created_at,userName);
    }
}
