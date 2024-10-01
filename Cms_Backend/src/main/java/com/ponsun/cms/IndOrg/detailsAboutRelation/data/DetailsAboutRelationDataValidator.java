package com.ponsun.cms.IndOrg.detailsAboutRelation.data;

import com.ponsun.cms.IndOrg.detailsAboutRelation.request.CreateDetailsAboutRelationRequest;
import com.ponsun.cms.IndOrg.detailsAboutRelation.request.UpdateDetailsAboutRelationRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DetailsAboutRelationDataValidator {
    public void validateSaveDetailsAboutRelationData(final CreateDetailsAboutRelationRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("cmsId parameter required");
        }
    }
    public void validateUpdateDetailsAboutRelationData(final UpdateDetailsAboutRelationRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("cmsId parameter required");
        }
    }
}

