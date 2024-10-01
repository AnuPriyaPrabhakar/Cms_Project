package com.ponsun.cms.Edit.ManagerPending.services;

import com.ponsun.cms.Edit.Manager.data.QcManagerPendingData;
import com.ponsun.cms.Edit.ManagerPending.rowmapper.QcManagerPendingRowMapper;
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
public class QcManagerPendingWritePlatformServiceImpl implements QcManagerPendingWritePlatformService {
    private final JdbcTemplate jdbcTemplate;
    private final QcManagerPendingRowMapper qcManagerPendingRowMapper;

    @Override
    public List<QcManagerPendingData> fetchAllQcManagerPendingData(String fromDate, String toDate) {
        final QcManagerPendingRowMapper rowMapper = new QcManagerPendingRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.cmsId=b.id AND a.status='A' AND manager_view=0 AND qc_approved=1 ";
        Qry = Qry + whereClause;
        final List<QcManagerPendingData> qcManagerPendingData = jdbcTemplate.query(Qry, qcManagerPendingRowMapper);
        return qcManagerPendingData;
    }


}
