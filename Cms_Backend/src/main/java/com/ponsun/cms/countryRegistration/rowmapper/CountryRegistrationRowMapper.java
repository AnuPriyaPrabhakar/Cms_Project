package com.ponsun.cms.countryRegistration.rowmapper;


import com.ponsun.cms.countryRegistration.data.CountryRegistrationData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class CountryRegistrationRowMapper implements RowMapper<CountryRegistrationData> {
    private final String schema;
    public CountryRegistrationRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_country_registration cd ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cd.id as id, ");
        builder.append("cd.countryId as countryId, ");
        builder.append("cd.recordTypeId as recordTypeId, ");
        builder.append("cd.cmsId as cmsId ,");
        builder.append("cd.countryHqId as countryHqId, ");
        builder.append("cd.identificationNumberId as identificationNumberId, ");
        builder.append("cd.identificationNum as identificationNum, ");
        builder.append("cd.identificationDetails as identificationDetails, ");
        builder.append("cd.contactId as contactId, ");
        builder.append("cd.contactName as contactName, ");
        builder.append("cd.status as status, ");
        builder.append("cd.uid as uid, ");
        builder.append("cd.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public CountryRegistrationData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer countryId = rs.getInt("countryId");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer cmsId = rs.getInt("cmsId");
        final Integer countryHqId = rs.getInt("countryHqId");
        final Integer identificationNumberId = rs.getInt("identificationNumberId");
        final String  identificationNum = rs.getString("identificationNum");
        final String  identificationDetails = rs.getString("identificationDetails");
        final Integer  contactId = rs.getInt("contactId");
        final String  contactName = rs.getString("contactName");
        final String  status = rs.getString("status");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CountryRegistrationData(id,countryId,recordTypeId,cmsId,countryHqId,identificationNumberId,identificationNum,identificationDetails,contactId,contactName,status,uid,euid);
    }
}
