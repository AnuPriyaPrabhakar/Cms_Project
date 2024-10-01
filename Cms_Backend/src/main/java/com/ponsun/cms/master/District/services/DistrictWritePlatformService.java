package com.ponsun.cms.master.District.services;

import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.master.District.request.CreateDistrictRequest;
import com.ponsun.cms.master.District.request.UpdateDistrictRequest;

public interface DistrictWritePlatformService {
    Response createDistrict(CreateDistrictRequest createDistrictRequest);

    Response updateDistrict(Integer id, UpdateDistrictRequest updateDistrictRequest);
    Response blockDistrict(Integer id);
    Response unblockDistrict(Integer id);
}
