package com.ponsun.cms.IndOrg.relation.data;

import com.ponsun.cms.IndOrg.relation.request.CreateRelationRequest;
import com.ponsun.cms.IndOrg.relation.request.UpdateRelationRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RelationDataValidator {
    public void validateSaveRelationData(final CreateRelationRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("Relationship parameter required");
        }
    }
    public void validateUpdateRelationData(final UpdateRelationRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("Relationship parameter required");
        }
    }
}
