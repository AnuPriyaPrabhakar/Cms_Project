package com.ponsun.cms.master.State.services;

import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.master.State.request.CreateStateRequest;
import com.ponsun.cms.master.State.request.UpdateStateRequest;

public interface StateWritePlatformService {
    Response createState(CreateStateRequest createStateRequest);
    Response updateState(Integer id, UpdateStateRequest updateStateRequest);
    Response blockState(Integer id);
    Response unblockState(Integer id);
}
