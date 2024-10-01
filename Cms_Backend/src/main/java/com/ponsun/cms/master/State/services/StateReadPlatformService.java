package com.ponsun.cms.master.State.services;

import com.ponsun.cms.master.State.domain.State;

import java.util.List;

public interface StateReadPlatformService {
    State fetchStateById(Integer id);
    List<State> fetchAllState();
}
