package com.ponsun.cms.getDocumnetType.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetDocumentTypeReadPlatformServiceImpl implements  GetDocumentTypeReadPlatformService{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Integer> getDocumentType(Integer documentId, Integer pathId) {

        String Qry = "SELECT id FROM cms_document WHERE documentId = ? AND pathId = ? AND STATUS='A'";
        List<Integer> getDocumentTypeDataList = jdbcTemplate.query(Qry, new Object[]{documentId, pathId}, (resultSet, rowNum) ->
                resultSet.getInt("id"));

        return getDocumentTypeDataList;
    }
}
