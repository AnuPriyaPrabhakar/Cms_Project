package com.ponsun.cms.cutomerAllData.rowmapper;


import com.ponsun.cms.cutomerAllData.data.CustomerAllDataData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j

public class CustomerAllDataRowMapper implements RowMapper <CustomerAllDataData>{

    private final String schema;

    public CustomerAllDataRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_details a , admin_users b   ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.genderId , a.recordTypeId , a.uid=b.id AS uid,a.id AS cmsId ,b.full_name  AS userName,NAME AS NAME,sourceLink AS sourceLink , a.created_at AS created_at");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public  CustomerAllDataData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer genderId = rs.getInt("genderId");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer cmsId = rs.getInt("cmsId");
        final String userName = rs.getString("userName");
        final String name = rs.getString("name");
        final String sourceLink = rs.getString("sourceLink");
        final String uid =rs.getString("uid");
        final String created_at =rs.getString("created_at");
        final String frmDate = "";//rs.getString("frmDate");
        final String toDate = "";//rs.getString("toDate");
        return new CustomerAllDataData(genderId , recordTypeId , cmsId , userName ,name , sourceLink , frmDate , toDate,uid , created_at);
    }
}
