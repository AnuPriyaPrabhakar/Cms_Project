package com.ponsun.cms.reports.QcViewDt.services;


import com.ponsun.cms.reports.QcViewDt.data.QcViewDtData;
import com.ponsun.cms.reports.QcViewDt.rowmapper.QcViewDtRowMapper;
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
public class QcViewDtWritePlatformServiceImpl implements QcViewDtWritePlatformService{
    private final JdbcTemplate jdbcTemplate;
    private final QcViewDtRowMapper qcViewDtRowMapper;
    @Override
    public List<QcViewDtData> fetchAllQcViewDtData(String frmDate, String toDate) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("frmDate", frmDate);
        parameters.put("toDate", toDate);
        final QcViewDtRowMapper rowmapper = new QcViewDtRowMapper();
        String Qry = "SELECT "  + rowmapper.tableSchema();
        String whereClause = " WHERE a.uid=b.id AND DATE(a.qc_view_dt) BETWEEN ? AND ?";
        Qry = Qry + whereClause;
        final List<QcViewDtData> qcViewDtData = jdbcTemplate.query(Qry,qcViewDtRowMapper,
                new Object[] {frmDate,toDate}
        );
        return qcViewDtData;
    }
}
