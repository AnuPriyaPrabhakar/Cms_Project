package com.ponsun.cms.master.RecordType.services;

import com.ponsun.cms.master.RecordType.request.CreateRecordTypeRequest;
import com.ponsun.cms.master.RecordType.request.UpdateRecordTypeRequest;
import com.ponsun.cms.infrastructure.utils.Response;

public interface RecordTypeWritePlatformService {
    Response createRecordType(CreateRecordTypeRequest createRecordTypeRequest);

    Response updateRecordType(Integer id, UpdateRecordTypeRequest updateRecordTypeRequest);
}
