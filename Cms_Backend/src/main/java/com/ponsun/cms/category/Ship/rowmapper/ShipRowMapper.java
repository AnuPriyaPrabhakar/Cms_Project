package com.ponsun.cms.category.Ship.rowmapper;

import com.ponsun.cms.category.Ship.data.ShipData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;


@Data
@Service
@Slf4j
public class ShipRowMapper implements RowMapper<ShipData> {

    private final String schema;
    public ShipRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_details a , cms_config_record_type b , admin_users c   ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.id AS cmsId , c.full_name AS userName , a.name AS cmsName,a.sourceLink AS SourceLink,a.genderId");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ShipData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer cmsId = rs.getInt("cmsId");
        final String userName = rs.getString("userName");
        final String cmsName = rs.getString("cmsName");
        final String sourceLink = rs.getString("sourceLink");
        final Integer genderId = rs.getInt("genderId");
        return ShipData.newInstance(cmsId,userName,cmsName,sourceLink,genderId);
    }
}
