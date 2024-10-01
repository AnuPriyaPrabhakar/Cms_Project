package com.ponsun.cms.FilesStorage.rowmapper;

import com.ponsun.cms.FilesStorage.data.FileStorageData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FileStorageRowMapper implements RowMapper<FileStorageData> {


    private final String schema;

    public FileStorageRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM cms_document cd");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cd.id as id");
        builder.append("cd.documentId as documentId");
        builder.append("cd.pathId as pathId");
        builder.append("cd.documentType as documentType");
        builder.append("cd.updated_at as dt");
        builder.append("cd.url as url");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public FileStorageData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String documentId = rs.getString("documentId");
        final Integer pathId = rs.getInt("pathId");
        final String documentType=rs.getString("documentType");
        final String dt = rs.getString("dt");
        final String url =rs.getString("url");
        return new FileStorageData(id,documentId,pathId,documentType,dt,url);
    }
}
