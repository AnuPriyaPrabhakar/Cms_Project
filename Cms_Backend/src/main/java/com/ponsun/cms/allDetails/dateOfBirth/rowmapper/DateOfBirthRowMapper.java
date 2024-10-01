package com.ponsun.cms.allDetails.dateOfBirth.rowmapper;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DateOfBirthDTO;
import com.ponsun.cms.allDetails.dateOfBirth.data.DateOfBirthData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class DateOfBirthRowMapper implements RowMapper<DateOfBirthDTO> {
    private final String schema;
    public DateOfBirthRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_birth_details cd ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cd.id as id, ");
        builder.append("cd.recordTypeId as recordTypeId, ");
        builder.append("cd.cmsId as cmsId, ");
        builder.append("cd.dob as dob, ");
        builder.append("cd.birthYearAlone as birthYearAlone, ");
        builder.append("cd.placeOfBirth as placeOfBirth, ");
        builder.append("cd.uid as uid, ");
        builder.append("cd.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public DateOfBirthDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer cmsId = rs.getInt("cmsId");
        final String dob = rs.getString("dob");
        final String birthYearAlone = rs.getString("birthYearAlone");
        final String placeOfBirth = rs.getString("placeOfBirth");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new DateOfBirthDTO(id,recordTypeId,cmsId,dob,birthYearAlone,placeOfBirth,uid,euid);
    }
}
