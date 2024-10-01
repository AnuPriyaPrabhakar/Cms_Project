package com.ponsun.cms.IndOrg.relationAliases.data;

import com.ponsun.cms.IndOrg.relationAliases.request.CreateRelationAliasesRequest;
import com.ponsun.cms.IndOrg.relationAliases.request.UpdateRelationAliasesRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RelationAliasesDataValidator {
    public void validateSaveRelationAliasesData(final CreateRelationAliasesRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
    public void validateUpdateRelationAliasesData(final UpdateRelationAliasesRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
}
