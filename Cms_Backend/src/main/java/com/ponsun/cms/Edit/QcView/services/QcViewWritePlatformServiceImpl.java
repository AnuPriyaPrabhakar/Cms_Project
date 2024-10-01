package com.ponsun.cms.Edit.QcView.services;


import com.ponsun.cms.Edit.QcView.data.QcViewData;
import com.ponsun.cms.Edit.QcView.rowmapper.QcViewRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class QcViewWritePlatformServiceImpl implements QcViewWritePlatformService {
    private final JdbcTemplate jdbcTemplate;
    private final QcViewRowMapper qcViewRowMapper;

    @Override
    public List<QcViewData> fetchAllQcViewData(String fromDate, String toDate) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fromDate",fromDate);
        parameters.put("toDate",toDate);
        final QcViewRowMapper rowMapper = new QcViewRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.cmsId=b.id AND a.status='A' AND qc_approved=0 AND qc_view=0";
        Qry = Qry + whereClause;
        final List<QcViewData> qcViewData  = jdbcTemplate.query(Qry,qcViewRowMapper,
                new Object[] {}
        );
        return qcViewData;
    }
}
