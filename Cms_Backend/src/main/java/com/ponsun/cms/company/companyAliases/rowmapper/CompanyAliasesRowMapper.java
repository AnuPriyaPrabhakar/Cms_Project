package com.ponsun.cms.company.companyAliases.rowmapper;


import com.ponsun.cms.company.commondto.dto.CompanyAliasesDTO;
import com.ponsun.cms.company.companyAliases.data.CompanyAliasesData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class CompanyAliasesRowMapper implements RowMapper<CompanyAliasesDTO> {
    private final String schema;

    public CompanyAliasesRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_company_aliases a ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id, ");
        builder.append("a.recordTypeId as recordTypeId, ");
        builder.append("a.cmsId as cmsId, ");
        builder.append("a.companyId as companyId, ");
        builder.append("a.aliasesName as aliasesName, ");
        builder.append("a.uid as uid, ");
        builder.append("a.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public CompanyAliasesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer cmsId = rs.getInt("cmsId");
        final Integer companyId = rs.getInt("companyId");
        final String aliasesName = rs.getString("aliasesName");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CompanyAliasesDTO(recordTypeId, cmsId, companyId, aliasesName, uid, euid);
    }
}
