package com.ponsun.cms.IndOrg.indAliasesName.data;

import com.ponsun.cms.IndOrg.indAliasesName.request.CreateIndAliasesNameRequest;
import com.ponsun.cms.IndOrg.indAliasesName.request.UpdateIndAliasesNameRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IndAliasesNameDataValidator {
    public void validateSaveIndAliasesNameData(final CreateIndAliasesNameRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
    public void validateUpdateIndAliasesNameData(final UpdateIndAliasesNameRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
}
