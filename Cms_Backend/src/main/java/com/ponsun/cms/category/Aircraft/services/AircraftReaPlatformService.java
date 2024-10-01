package com.ponsun.cms.category.Aircraft.services;


import com.ponsun.cms.category.Aircraft.data.AircraftData;

import java.util.List;

public interface AircraftReaPlatformService {
    List<AircraftData> fetchAllAircraftData(String cmsName);
}
