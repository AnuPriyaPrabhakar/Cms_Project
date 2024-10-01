package com.ponsun.cms.getDocumnetType.rowmapper;

import com.ponsun.cms.getDocumnetType.data.GetDocumentTypeData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class GetDocumentTypeRowMapper implements RowMapper<GetDocumentTypeData> {

    private final String schema;
    public GetDocumentTypeRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cms_document");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" id ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public GetDocumentTypeData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id" );
        final Integer documentId = rs.getInt("documentId" );
        final Integer pathId = rs.getInt("pathId" );
        final String documentType = rs.getString("documentType" );
        return GetDocumentTypeData.newInstance(id,documentId, pathId, documentType);
    }

}
