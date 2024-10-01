package com.ponsun.cms.master.Bank.rowmapper;


import com.ponsun.cms.master.Bank.data.BankData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class BankRowMapper implements RowMapper<BankData> {

    private final String schema;

    public BankRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_config_bank bank ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("bank.id as id, ");
        builder.append("bank.bankName as bankName ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public BankData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        return BankData.newInstance(id, name);
    }
}
