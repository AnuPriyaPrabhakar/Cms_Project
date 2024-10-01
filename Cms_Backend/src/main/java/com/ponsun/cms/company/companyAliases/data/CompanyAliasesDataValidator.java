package com.ponsun.cms.company.companyAliases.data;


import com.ponsun.cms.company.companyAliases.request.UpdateCompanyAliasesRequest;
import com.ponsun.cms.company.companyAliases.request.CreateCompanyAliasesRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyAliasesDataValidator {
    public void validateSaveCompanyAliasesData(final CreateCompanyAliasesRequest request) {
        if (request.getCmsId() == null || request.getCmsId().equals("")) {
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }

    public void validateUpdateCompanyAliasesData(final UpdateCompanyAliasesRequest request) {
        if (request.getCmsId() == null || request.getCmsId().equals("")) {
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
}
