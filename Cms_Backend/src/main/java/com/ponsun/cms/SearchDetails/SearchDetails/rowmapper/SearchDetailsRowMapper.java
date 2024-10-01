package com.ponsun.cms.SearchDetails.SearchDetails.rowmapper;

import com.ponsun.cms.SearchDetails.SearchDetails.data.SearchDetailsData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class SearchDetailsRowMapper implements RowMapper<SearchDetailsData> {
    private final String schema;

    public SearchDetailsRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_search_details cs , cms_search a ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" cs.id as id, ");
        builder.append(" cs.searchId as searchId, ");
        builder.append(" cs.cmsId as cmsId, ");
        builder.append(" cs.name as name, ");
        builder.append(" cs.searchingScore as searchingScore, ");
        builder.append(" cs.typeId as typeId, ");
        builder.append(" cs.uid as uid ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public SearchDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer searchId= rs.getInt("searchId");
        final Integer cmsId = rs.getInt("cmsId");
        final String name = rs.getString("name");
        final double searchingScore = rs.getDouble("searchingScore");
        final Integer typeId = rs.getInt("typeId");
        final Integer uid = rs.getInt("uid");
        final String fromDate = "";//rs.getString("fromDate");
        final String toDate = "";//rs.getString("toDate");
        return new SearchDetailsData(id,searchId,cmsId,name, searchingScore, typeId, uid, fromDate, toDate);
    }
}
