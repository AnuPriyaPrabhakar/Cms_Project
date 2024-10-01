package com.ponsun.cms.company.companyDetails.services;

import com.ponsun.cms.company.commondto.dto.CompanyDetailsDTO;
import com.ponsun.cms.company.companyDetails.request.CreateCompanyDetailsRequest;
import com.ponsun.cms.company.companyDetails.request.UpdateCompanyDetailsRequest;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface CompanyDetailsWritePlatFormService {
    Response createCompanyDetails(CreateCompanyDetailsRequest createCompanyDetailsRequest);
    Response updateCompanyDetails(Integer id, UpdateCompanyDetailsRequest updateCompanyDetailsRequest);
    List<CompanyDetailsDTO> fetchAllCompanyDetailsData(Integer cmsId);
    Response deActivate(Integer cmsId, Integer euid);
}
