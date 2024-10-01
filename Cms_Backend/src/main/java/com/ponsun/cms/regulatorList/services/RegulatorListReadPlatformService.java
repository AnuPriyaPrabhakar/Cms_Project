package com.ponsun.cms.regulatorList.services;

import com.ponsun.cms.regulatorList.domain.RegulatorList;

import java.util.List;
public interface RegulatorListReadPlatformService {


    RegulatorList fetchRegulatorListById(Integer id);

    List<RegulatorList> fetchAllRegulatorList();
}
