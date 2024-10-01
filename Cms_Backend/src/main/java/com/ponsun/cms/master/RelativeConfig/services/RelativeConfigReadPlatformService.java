package com.ponsun.cms.master.RelativeConfig.services;



import com.ponsun.cms.master.RelativeConfig.domain.RelativeConfig;

import java.util.List;

public interface RelativeConfigReadPlatformService {
    List<RelativeConfig> fetchAllRelative();

    RelativeConfig fetchRelativeById(Integer id);
}
