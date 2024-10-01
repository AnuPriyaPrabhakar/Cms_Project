package com.ponsun.cms.IndCaseDetails.services;

import com.ponsun.cms.IndCaseDetails.domain.IndCaseDetails;

import java.util.List;

public interface IndCaseDetailsReadPlatFormService {
    List<IndCaseDetails> fetchAllCaseDetails();

    IndCaseDetails fetchCaseDetailsById(Integer id);
}
