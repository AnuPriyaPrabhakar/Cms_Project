package com.ponsun.cms.IndOrg.indAliasesName.rowmapper;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.IndAliasesNameDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class IndAliasesNameRowMapper implements RowMapper<IndAliasesNameDTO> {
    private final String schema;
    public IndAliasesNameRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_individual_aliases_name ian ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ian.cmsId as cmsId, ");
        builder.append("ian.recordTypeId as recordTypeId, ");
        builder.append("ian.positionId as positionId,");
        builder.append("ian.linIndAliasesName as linIndAliasesName,");
        builder.append("ian.uid as uid, ");
        builder.append("ian.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public IndAliasesNameDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer cmsId = rs.getInt("cmsId");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer positionId = rs.getInt("positionId");
        final String linIndAliasesName = rs.getString("linIndAliasesName");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new IndAliasesNameDTO (cmsId, recordTypeId, positionId, linIndAliasesName,uid,euid);
    }
}
