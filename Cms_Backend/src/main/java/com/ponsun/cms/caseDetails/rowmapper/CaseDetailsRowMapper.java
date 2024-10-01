package com.ponsun.cms.caseDetails.rowmapper;


import com.ponsun.cms.caseDetails.data.CaseDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class CaseDetailsRowMapper implements RowMapper<CaseDetailsData> {
    private final String schema;
    public CaseDetailsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_case_details ccd ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ccd.id as id, ");
        builder.append("ccd.recordTypeId as recordTypeId, ");
        builder.append("ccd.cmsId as cmsId, ");
        builder.append("ccd.caseDetails as caseDetails, ");
        builder.append("ccd.uid as uid, ");
        builder.append("ccd.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public CaseDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer cmsId = rs.getInt("cmsId");
        final String  caseDetails = rs.getString("caseDetails");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CaseDetailsData(recordTypeId,cmsId,caseDetails,uid,euid);
    }
}
