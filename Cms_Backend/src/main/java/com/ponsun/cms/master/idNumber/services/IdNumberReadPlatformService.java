package com.ponsun.cms.master.idNumber.services;

import com.ponsun.cms.master.idNumber.domain.IdNumber;

import java.util.List;

public interface IdNumberReadPlatformService {
    List<IdNumber> fetchAllIdNumber();

    IdNumber fetchIdNumberById(Integer id);
}
