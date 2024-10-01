package com.ponsun.cms.managerView.rowmapper;

import com.ponsun.cms.managerView.data.ManagerViewGetViewData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;


@Data
@Service
@Slf4j
public class ManagerViewGetMapper implements RowMapper<ManagerViewGetViewData> {

    private final String schema;
    public ManagerViewGetMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_details a  , admin_users c   ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.id AS cmsId ,c.uid , a.recordTypeId , c.full_name AS userName , a.name AS cmsName,a.sourceLink AS SourceLink,a.genderId");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ManagerViewGetViewData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer cmsId = rs.getInt("cmsId");
        final String userName = rs.getString("userName");
        final String cmsName = rs.getString("cmsName");
        final String sourceLink = rs.getString("sourceLink");
        final Integer genderId = rs.getInt("genderId");
        final Integer uid = rs.getInt("uid");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        return ManagerViewGetViewData.newInstance(cmsId,userName,cmsName,sourceLink,genderId,uid,recordTypeId);
    }
}
