package com.ponsun.cms.IndOrg.positions.services;

import com.ponsun.cms.IndOrg.positions.domain.Positions;
import java.util.List;

public interface PositionsReadPlatformService {
    List<Positions> fetchAllPositions();

    Positions fetchPositionsById(Integer id);
}
