package com.ponsun.cms.IndPositions.services;

import com.ponsun.cms.IndPositions.domain.IndPositions;

import java.util.List;

public interface IndPositionsReadPlatformService {
    List<IndPositions> fetchAllIndPositions();

    IndPositions fetchIndPositionsById(Integer id);
}
