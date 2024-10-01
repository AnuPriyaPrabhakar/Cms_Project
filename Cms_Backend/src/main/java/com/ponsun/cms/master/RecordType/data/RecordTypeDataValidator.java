package com.ponsun.cms.master.RecordType.data;

import com.ponsun.cms.master.RecordType.request.CreateRecordTypeRequest;
import com.ponsun.cms.master.RecordType.request.UpdateRecordTypeRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RecordTypeDataValidator {
    public void validateSaveRecordType(final CreateRecordTypeRequest request){
        if(request.getName() == null || request.getName().equals("")){
            throw new EQAS_CMS_ApplicationException("CompanyId parameter required");
        }
    }
    public void validateUpdateRecordType(final UpdateRecordTypeRequest request){
        if(request.getUid() == null || request.getUid().equals("")){
            throw new EQAS_CMS_ApplicationException("CompanyId parameter required");
        }
    }
}
