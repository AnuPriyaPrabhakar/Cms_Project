package com.ponsun.cms.company.companyDetails.rowmapper;


import com.ponsun.cms.company.commondto.dto.CompanyDetailsDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class CompanyDetailsRowMapper implements RowMapper<CompanyDetailsDTO> {
    private final String schema;
    public CompanyDetailsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_company_details company ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("company.id as id, ");
        builder.append("company.recordTypeId as recordTypeId, ");
        builder.append("company.cmsId as cmsId, ");
        builder.append("company.identificationNumberId as identificationNumberId, ");
        builder.append("company.stateId as stateId, ");
        builder.append("company.role as role, ");
        builder.append("company.companyName as companyName, ");
        builder.append("company.address as address, ");
        builder.append("company.idDetails as idDetails, ");
        builder.append("company.uid as uid, ");
        builder.append("company.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public CompanyDetailsDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer cmsId = rs.getInt("cmsId");
        final Integer identificationNumberId = rs.getInt("identificationNumberId");
        final Integer stateId = rs.getInt("stateId");
        final String  role = rs.getString("role");
        final String  companyName = rs.getString("companyName");
        final String  address = rs.getString("address");
        final String  idDetails = rs.getString("idDetails");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CompanyDetailsDTO(id,recordTypeId, cmsId, identificationNumberId,stateId, role, companyName, address, idDetails, uid, euid);
    }
}
