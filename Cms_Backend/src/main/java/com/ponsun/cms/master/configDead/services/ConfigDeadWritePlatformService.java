package com.ponsun.cms.master.configDead.services;

import com.ponsun.cms.master.configDead.request.CreateConfigDeadRequest;
import com.ponsun.cms.master.configDead.request.UpdateConfigDeadRequest;
import com.ponsun.cms.infrastructure.utils.Response;

public interface ConfigDeadWritePlatformService {


    Response createConfigDead(CreateConfigDeadRequest createConfigDeadRequest);

    Response updateConfigDead(Integer id, UpdateConfigDeadRequest updateConfigDeadRequest);

    Response blockConfigDead(Integer id);

    Response unblockConfigDead(Integer id);
}
