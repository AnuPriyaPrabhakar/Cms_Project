package com.ponsun.cms.master.District.services;

import com.ponsun.cms.master.District.domain.District;
import java.util.List;

public interface DistrictReadPlatformService {
    List<District> fetchAllDistrict();
    District fetchDistrictById(Integer id);
}
