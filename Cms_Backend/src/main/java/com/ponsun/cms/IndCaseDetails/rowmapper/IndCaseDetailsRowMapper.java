package com.ponsun.cms.IndCaseDetails.rowmapper;


import com.ponsun.cms.IndCaseDetails.data.IndCaseDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class IndCaseDetailsRowMapper implements RowMapper<IndCaseDetailsData> {
    private final String schema;
    public IndCaseDetailsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_individual_case_details cd ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cd.id as id, ");
        builder.append("cd.recordTypeId as recordTypeId, ");
        builder.append("cd.cmsId as cmsId, ");
        builder.append("cd.caseDetails as caseDetails, ");
        builder.append("cd.uid as uid, ");
        builder.append("cd.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public IndCaseDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer cmsId = rs.getInt("cmsId");
        final String  caseDetails = rs.getString("caseDetails");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new IndCaseDetailsData(recordTypeId,cmsId,caseDetails,uid,euid);
    }
}
