package com.ponsun.cms.regulator.services;

import com.ponsun.cms.regulator.request.CreateRegulatorRequest;
import com.ponsun.cms.regulator.request.UpdateRegulatorRequest;
import com.ponsun.cms.infrastructure.utils.Response;

public interface RegulatorWritePlatformService {


    Response createRegulator(CreateRegulatorRequest createRegulatorRequest);

    Response updateRegulator(Integer id, UpdateRegulatorRequest updateRegulatorRequest);

    Response blockRegulator(Integer id);

    Response unblockRegulator(Integer id);

}
