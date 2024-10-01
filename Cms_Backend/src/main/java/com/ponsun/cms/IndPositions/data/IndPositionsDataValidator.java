package com.ponsun.cms.IndPositions.data;


import com.ponsun.cms.IndPositions.request.CreateIndPositionsRequest;
import com.ponsun.cms.IndPositions.request.UpdateIndPositionsRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IndPositionsDataValidator {
    public void validateSaveIndPositionsData(final CreateIndPositionsRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
    public void validateUpdateIndPositionsData(final UpdateIndPositionsRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
}
