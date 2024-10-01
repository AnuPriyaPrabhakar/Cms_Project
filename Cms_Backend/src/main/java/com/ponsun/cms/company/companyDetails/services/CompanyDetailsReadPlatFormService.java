package com.ponsun.cms.company.companyDetails.services;

import com.ponsun.cms.company.companyDetails.domain.CompanyDetails;

import java.util.List;

public interface CompanyDetailsReadPlatFormService {
    List<CompanyDetails> fetchAllCompanyDetails();

    CompanyDetails fetchCompanyDetailsById(Integer id);
}
