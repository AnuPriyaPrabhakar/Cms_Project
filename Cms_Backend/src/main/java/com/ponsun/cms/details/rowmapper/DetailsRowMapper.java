package com.ponsun.cms.details.rowmapper;

import com.ponsun.cms.details.data.DetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class DetailsRowMapper implements RowMapper<DetailsData> {
    private final String schema;
    public DetailsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_details cd ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cd.id as id, ");
        builder.append("cd.recordTypeId as recordTypeId, ");
        builder.append("cd.regulatorListId as regulatorListId,");
        builder.append("cd.regulatorId as regulatorId,");
        builder.append("cd.display as display, ");
        builder.append("cd.sourceLink as sourceLink, ");
        builder.append("cd.name as name, ");
        builder.append("cd.registrationNum as registrationNum, ");
        builder.append("cd.genderId as genderId, ");
        builder.append("cd.deadId as deadId, ");
        builder.append("cd.uid as uid, ");
        builder.append("cd.euid as euid ,");
        builder.append("cd.qcViewDt as qcViewDt,");
        builder.append("cd.qcEditDt as qcEditDt,");
        builder.append("cd.managerApproveDt as managerApproveDt,");
        builder.append("cd.qcPendingDt as qcPendingDt,");
        builder.append("cd.publishedDt as publishedDt,");
        builder.append("cd.managerPendingDt as managerPendingDt");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public DetailsData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer regulatorListId = rs.getInt("regulatorListId");
        final Integer regulatorId = rs.getInt("regulatorId");
        final Integer display = rs.getInt("display");
        final String sourceLink = rs.getString("sourceLink");
        final String name = rs.getString("name");
        final String registrationNum = rs.getString("registrationNum");
        final Integer genderId = rs.getInt("genderId");
        final Integer deadId = rs.getInt("deadId");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        final String qcViewDt = rs.getString("qcViewDt");
        final String qcEditDt = rs.getString("qcEditDt");
        final String managerApproveDt = rs.getString("managerApproveDt");
        final String qcPendingDt = rs.getString("qcPendingDt");
        final String publishedDt = rs.getString("publishedDt");
        final String managerPendingDt = rs.getString("managerPendingDt");
        return new DetailsData(id,recordTypeId,regulatorListId,regulatorId,display,sourceLink,name,registrationNum,genderId,deadId,uid,euid,qcViewDt,qcEditDt,managerApproveDt,qcPendingDt,publishedDt,managerPendingDt);
    }
}
