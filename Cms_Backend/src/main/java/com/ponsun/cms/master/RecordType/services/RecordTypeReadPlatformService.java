package com.ponsun.cms.master.RecordType.services;

import com.ponsun.cms.master.RecordType.domain.RecordType;

import java.util.List;

public interface RecordTypeReadPlatformService {
    List<RecordType> fetchAllRecordType();

    RecordType fetchRecordTypeById(Integer id);
}
