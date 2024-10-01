package com.ponsun.cms.commonDetails.rowmapper;



import com.ponsun.cms.commonDetails.data.StatusDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j

public class StatusDetailsDTORowMapper implements RowMapper<StatusDetailsData> {
    private final String schema;
    public StatusDetailsDTORowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_details a,cms_config_record_type b ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.id AS cmsId ,a.name AS cmsName,b.name AS cmsRecordType , a.registrationNum AS registrationNum , a.recordTypeId AS recordTypeId");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public StatusDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer cmsId = rs.getInt("cmsId");
        final String  cmsName = rs.getString("cmsName");
        final String  cmsRecordType = rs.getString("cmsRecordType");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final String registrationNum = rs.getString("registrationNum");
        return StatusDetailsData.newInstance(cmsId,cmsName,cmsRecordType,recordTypeId,registrationNum);
    }
}


