package com.ponsun.cms.master.configDead.services;

import com.ponsun.cms.master.configDead.domain.ConfigDead;

import java.util.List;
public interface ConfigDeadReadPlatformService {


    ConfigDead fetchConfigDeadById(Integer id);

    List<ConfigDead> fetchAllConfigDead();
}
