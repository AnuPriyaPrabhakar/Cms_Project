package com.ponsun.cms.IndPositions.services;

import com.ponsun.cms.IndPositions.data.IndPositionsData;
import com.ponsun.cms.IndPositions.request.CreateIndPositionsRequest;
import com.ponsun.cms.IndPositions.request.UpdateIndPositionsRequest;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;

import java.util.List;

public interface IndPositionsWritePlatformService {
    Response createIndPositions(CreateIndPositionsRequest createIndPositionsRequest);

    Response updateIndPositions(Integer id, UpdateIndPositionsRequest updateIndPositionsRequest);

    @Transactional
    List<IndPositionsData> fetchIndPositionsData(Integer cmsId);

    @Transactional
    Response deactive(Integer cmsId, Integer euid);
}
