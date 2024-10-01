package com.ponsun.cms.bankDetails.rowmapper;


import com.ponsun.cms.bankDetails.data.BankDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class BankDetailsRowMapper implements RowMapper<BankDetailsData> {
    private final String schema;
    public BankDetailsRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_bank_details cbd ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cbd.id as id, ");
        builder.append("cbd.recordTypeId as recordTypeId, ");
        builder.append("cbd.cmsId as cmsId, ");
        builder.append("cbd.bankId as bankId, ");
        builder.append("cbd.acc_no as acc_no, ");
        builder.append("cbd.name as name, ");
        builder.append("cbd.uid as uid, ");
        builder.append("cbd.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public BankDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer recordTypeId = rs.getInt("recordTypeId");
        final Integer cmsId = rs.getInt("cmsId");
        final Integer bankId = rs.getInt("bankId");
        final String  acc_no = rs.getString("acc_no");
        final String  name = rs.getString("name");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new BankDetailsData(recordTypeId,cmsId,bankId,acc_no,name,uid,euid);
    }
}
