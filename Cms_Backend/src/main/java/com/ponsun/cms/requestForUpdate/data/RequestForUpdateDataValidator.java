package com.ponsun.cms.requestForUpdate.data;


import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.requestForUpdate.request.CreateRequestForUpdateRequest;
import com.ponsun.cms.requestForUpdate.request.UpdateRequestForUpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RequestForUpdateDataValidator {
    public void validateSaveRequestForUpdate (final CreateRequestForUpdateRequest request) {
        if (request.getRequestForUpdate() == null || request.getRequestForUpdate().equals("")) {
            throw new EQAS_CMS_ApplicationException("RequestForUpdate parameter required");
        }
    }
    public void validateUpdateRequestForUpdate (final UpdateRequestForUpdateRequest request) {
        if (request.getRequestForUpdate() == null || request.getRequestForUpdate().equals("")) {
            throw new EQAS_CMS_ApplicationException("RequestForUpdate parameter required");
        }
    }
}
