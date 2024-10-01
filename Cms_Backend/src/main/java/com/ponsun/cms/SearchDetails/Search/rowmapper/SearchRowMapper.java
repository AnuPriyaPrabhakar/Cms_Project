package com.ponsun.cms.SearchDetails.Search.rowmapper;


import com.ponsun.cms.SearchDetails.Search.data.SearchData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class SearchRowMapper implements RowMapper<SearchData> {
    private final String schema;

    public SearchRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_search a , cms_search_details b ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id as id, ");
        builder.append("a.name as name, ");
        builder.append("a.matchingScore as matchingScore ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public SearchData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final double matchingScore = rs.getDouble("matchingScore");
        final String fromDate = "";//rs.getString("fromDate");
        final String toDate = "";//rs.getString("toDate");
        return new SearchData(id,  name, matchingScore,fromDate,toDate);
    }
}