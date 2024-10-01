package com.ponsun.cms.Edit.ViewApprove.services;

import com.ponsun.cms.Edit.ViewApprove.data.ViewApproveData;
import com.ponsun.cms.Edit.ViewApprove.rowmapper.ViewApproveRowMapper;
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
public class ViewApproveReadPlatformServiceImpl implements ViewApproveReadPlatformService{

    private final JdbcTemplate jdbcTemplate;
    private final ViewApproveRowMapper viewApproveRowMapper;

    @Override
    public List<ViewApproveData> fetchAllViewApproveData(String fromDate, String toDate) {

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("fromDate",fromDate);
            parameters.put("toDate",toDate);


        final ViewApproveRowMapper rowMapper = new ViewApproveRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.cmsId=b.id AND a.status='A' AND qc_approved=0 AND qc_view=1";
        Qry = Qry + whereClause;
        final List<ViewApproveData> viewApproveData  = jdbcTemplate.query(Qry,viewApproveRowMapper,
                new Object[] {}
        );
        return viewApproveData;
    }

}
