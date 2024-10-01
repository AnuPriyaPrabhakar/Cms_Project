package com.ponsun.cms.company.companyAliases.services;

import com.ponsun.cms.company.companyAliases.domain.CompanyAliases;

import java.util.List;

public interface CompanyAliasesReadService {
    List<CompanyAliases> fetchAllCompanyAliases();

    CompanyAliases fetchCompanyAliasesById(Integer id);
}
