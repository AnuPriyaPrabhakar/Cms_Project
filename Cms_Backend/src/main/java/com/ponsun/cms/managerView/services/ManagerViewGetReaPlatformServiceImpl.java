package com.ponsun.cms.managerView.services;


import com.ponsun.cms.managerView.data.ManagerViewGetViewData;
import com.ponsun.cms.managerView.rowmapper.ManagerViewGetMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class ManagerViewGetReaPlatformServiceImpl implements ManagerViewGetReaPlatformService {

    private final ManagerViewGetMapper managerViewGetMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ManagerViewGetViewData> fetchAllManagerViewData(String cmsName ) {
        final ManagerViewGetMapper rowMapper = new ManagerViewGetMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = "  WHERE a.uid=c.id AND a.status = 'A' AND a.name = ?";
        Qry = Qry + whereClause;
        final List<ManagerViewGetViewData> managerViewGetViewData = jdbcTemplate.query(Qry, managerViewGetMapper,
                new Object[]{cmsName}
        );
        return managerViewGetViewData;
    }
}



