package com.ponsun.cms.regulatorList.services;

import com.ponsun.cms.regulatorList.request.CreateRegulatorListRequest;
import com.ponsun.cms.regulatorList.request.UpdateRegulatorListRequest;
import com.ponsun.cms.infrastructure.utils.Response;

public interface RegulatorListWritePlatformService {


    Response createRegulatorList(CreateRegulatorListRequest createAddressRequest);

    Response updateRegulatorList(Integer id, UpdateRegulatorListRequest updateAddressRequest);

    Response blockRegulatorList(Integer id);

    Response unblockRegulatorList(Integer id);

}
