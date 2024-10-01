package com.ponsun.cms.IndOrg.detailsAboutRelation.rowmapper;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.DetailsAboutRelationDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class DetailsAboutRelationRowMapper implements RowMapper<DetailsAboutRelationDTO> {
    private final String schema;
    public DetailsAboutRelationRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_details_about_relation dar ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("dar.cmsId as cmsId, ");
        builder.append("dar.recordTypeId as recordTypeId, ");
        builder.append("dar.positionId as positionId,");
        builder.append("dar.detailsAboutRelation as detailsAboutRelation,");
        builder.append("dar.uid as uid, ");
        builder.append("dar.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public DetailsAboutRelationDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer cmsId = rs.getInt("cmsId");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer positionId = rs.getInt("positionId");
        final String detailsAboutRelation = rs.getString("detailsAboutRelation");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new DetailsAboutRelationDTO (cmsId, recordTypeId, positionId, detailsAboutRelation,uid,euid);
    }
}
