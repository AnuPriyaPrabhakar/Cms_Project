package com.ponsun.cms.company.companyAliases.services;

import com.ponsun.cms.company.commondto.dto.CompanyAliasesDTO;
import com.ponsun.cms.company.companyAliases.request.UpdateCompanyAliasesRequest;
import com.ponsun.cms.company.companyAliases.data.CompanyAliasesData;
import com.ponsun.cms.company.companyAliases.request.CreateCompanyAliasesRequest;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface CompanyAliasesWriteService {
    Response createCompanyAliases(CreateCompanyAliasesRequest createCompanyAliasesRequest);

    List<CompanyAliasesDTO> fetchAllCompanyAliasesData(Integer cmsId , Integer companyId);

    Response updateCompanyAliases(Integer id, UpdateCompanyAliasesRequest updateCompanyAliasesRequest);

    Response deactive(Integer cmsId, Integer euid);
}
