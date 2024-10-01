package com.ponsun.cms.allDetails.address.rowmapper;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.AddressDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class AddressRowMapper implements RowMapper<AddressDTO> {

    private final String schema;
    public AddressRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_address ad ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ad.id as id, ");
        builder.append("ad.recordTypeId as recordTypeId, ");
        builder.append("ad.cmsId as cmsId ,");
        builder.append("ad.address as address, ");
        builder.append("ad.uid as uid, ");
        builder.append("ad.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public AddressDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer recordTypeId =rs.getInt("recordTypeId");
        final Integer cmsId=rs.getInt("cmsId");
        final String  address = rs.getString("address");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new AddressDTO(id,recordTypeId,cmsId,address,uid,euid);
    }
}
