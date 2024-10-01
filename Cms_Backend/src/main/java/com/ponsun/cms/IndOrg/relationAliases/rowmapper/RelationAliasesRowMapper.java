package com.ponsun.cms.IndOrg.relationAliases.rowmapper;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.RelationAliasesDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class RelationAliasesRowMapper implements RowMapper<RelationAliasesDTO> {
    private final String schema;
    public RelationAliasesRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_relation_aliases_name ran ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ran.cmsId as cmsId, ");
        builder.append("ran.recordTypeId as recordTypeId, ");
        builder.append("ran.positionId as positionId,");
        builder.append("ran.relationAliasesName as relationAliasesName,");
        builder.append("ran.uid as uid, ");
        builder.append("ran.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public RelationAliasesDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer cmsId = rs.getInt("cmsId");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer positionId = rs.getInt("positionId");
        final String relationAliasesName = rs.getString("relationAliasesName");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new RelationAliasesDTO (cmsId, recordTypeId, positionId, relationAliasesName,uid,euid);
    }
}
