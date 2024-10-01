package com.ponsun.cms.Edit.ManagerViewPending.rowmapper;

import com.ponsun.cms.Edit.ManagerViewPending.data.ManagerViewPendingData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class ManagerViewPendingRowMapper implements RowMapper<ManagerViewPendingData> {
    private final String schema;

    public ManagerViewPendingRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_task_reassign_status a,cms_details b  ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" b.recordTypeId AS recordTypeId,b.name AS NAME,b.genderId AS genderId,b.sourceLink AS sourceLink");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ManagerViewPendingData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final String  name = rs.getString("name");
        final Integer genderId = rs.getInt("genderId");
        final String sourceLink = rs.getString("sourceLink");
        final String fromDate = "";//rs.getString("fromDate");
        final String toDate = "";//rs.getString("toDate");
        return ManagerViewPendingData.newInstance(recordTypeId,name,genderId,sourceLink,fromDate,toDate);
    }
}