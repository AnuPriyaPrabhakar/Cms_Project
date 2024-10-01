package com.ponsun.cms.IndOrg.relation.rowmapper;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.RelationDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class RelationRowMapper implements RowMapper<RelationDTO> {
    private final String schema;
    public RelationRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_relations relation ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("relation.cmsId as cmsId, ");
        builder.append("relation.recordTypeId as recordTypeId, ");
        builder.append("relation.positionId as positionId,");
        builder.append("relation.relativeMasterId as relativeMasterId,");
        builder.append("relation.relationship as relationship,");
        builder.append("relation.uid as uid, ");
        builder.append("relation.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public RelationDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer cmsId = rs.getInt("cmsId");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer positionId = rs.getInt("positionId");
        final Integer relativeMasterId = rs.getInt("relativeMasterId");
        final String relationship = rs.getString("relationship");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new RelationDTO (cmsId, recordTypeId, positionId, relativeMasterId,relationship,uid,euid);
    }
}
