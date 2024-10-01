package com.ponsun.cms.IndCaseDetails.services;

import com.ponsun.cms.IndCaseDetails.data.IndCaseDetailsData;
import com.ponsun.cms.IndCaseDetails.request.CreateIndCaseDetailsRequest;
import com.ponsun.cms.IndCaseDetails.request.UpdateIndCaseDetailsRequest;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface IndCaseDetailsWritePlatFormService {
    Response createIndCaseDetails(CreateIndCaseDetailsRequest createIndCaseDetailsRequest);

    Response updateIndCaseDetails(Integer id, UpdateIndCaseDetailsRequest updateIndCaseDetailsRequest);

    List<IndCaseDetailsData> fetchAllCaseDetailsData(Integer cmsId);

    Response deactive(Integer cmsId, Integer euid);
}
