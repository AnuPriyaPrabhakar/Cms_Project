package com.ponsun.cms.regulator.services;

import com.ponsun.cms.regulator.domain.Regulator;

import java.util.List;
public interface RegulatorReadPlatformService {


    Regulator fetchRegulatorById(Integer id);

    List<Regulator> fetchAllRegulator();
}
