package com.ponsun.cms.IndOrg.positions.services;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.PositionsDTO;
import com.ponsun.cms.IndOrg.positions.request.CreatePositionsRequest;
import com.ponsun.cms.IndOrg.positions.request.UpdatePositionsRequest;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PositionsWritePlatformService {
    Response createPositions(CreatePositionsRequest createPositionsRequest);

    Response updatePositions(Integer id, UpdatePositionsRequest updatePositionsRequest);

    List<PositionsDTO> fetchPositionsDTO(Integer cmsId);

    Response DeActiveIndOrg(Integer cmsId, Integer euid);
}
