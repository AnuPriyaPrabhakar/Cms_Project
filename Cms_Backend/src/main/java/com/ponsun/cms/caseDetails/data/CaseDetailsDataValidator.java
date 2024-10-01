package com.ponsun.cms.caseDetails.data;



import com.ponsun.cms.caseDetails.request.CreateCaseDetailsRequest;
import com.ponsun.cms.caseDetails.request.UpdateCaseDetailsRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CaseDetailsDataValidator {
    public void validateSaveCaseDetailsData(final CreateCaseDetailsRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
    public void validateUpdateCaseDetailsData(final UpdateCaseDetailsRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
}
