package com.ponsun.cms.caseDetails.services;

import com.ponsun.cms.caseDetails.domain.CaseDetails;

import java.util.List;

public interface CaseDetailsReadPlatFormService {
    List<CaseDetails> fetchAllCaseDetails();

    CaseDetails fetchCaseDetailsById(Integer id);
}
