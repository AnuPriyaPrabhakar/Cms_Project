package com.ponsun.cms.category.Ship.services;


import com.ponsun.cms.category.Ship.data.ShipData;

import java.util.List;

public interface ShipReaPlatformService {
    List<ShipData> fetchAllShipData(String cmsName);
}
