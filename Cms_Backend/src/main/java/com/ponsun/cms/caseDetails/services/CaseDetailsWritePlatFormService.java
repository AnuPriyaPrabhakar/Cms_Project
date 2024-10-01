package com.ponsun.cms.caseDetails.services;

import com.ponsun.cms.caseDetails.data.CaseDetailsData;
import com.ponsun.cms.caseDetails.request.CreateCaseDetailsRequest;
import com.ponsun.cms.caseDetails.request.UpdateCaseDetailsRequest;
import com.ponsun.cms.infrastructure.utils.Response;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CaseDetailsWritePlatFormService {
    Response createCaseDetails(CreateCaseDetailsRequest createCaseDetailsRequest);

    Response updateCaseDetails(Integer id, UpdateCaseDetailsRequest updateAliasesNameRequest);

    List<CaseDetailsData> fetchAllCaseDetailsData(Integer cmsId);

    Response deactive(Integer cmsId, Integer euid);
}
