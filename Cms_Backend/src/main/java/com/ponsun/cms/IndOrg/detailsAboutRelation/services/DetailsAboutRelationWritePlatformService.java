package com.ponsun.cms.IndOrg.detailsAboutRelation.services;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.DetailsAboutRelationDTO;
import com.ponsun.cms.IndOrg.detailsAboutRelation.request.CreateDetailsAboutRelationRequest;
import com.ponsun.cms.IndOrg.detailsAboutRelation.request.UpdateDetailsAboutRelationRequest;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;

import java.util.List;

public interface DetailsAboutRelationWritePlatformService {
    Response createDetailsAboutRelation(CreateDetailsAboutRelationRequest createDetailsAboutRelationRequest);

    Response updateDetailsAboutRelation(Integer id, UpdateDetailsAboutRelationRequest updateDetailsAboutRelationRequest);

    List<DetailsAboutRelationDTO> fetchDetailsAboutRelationDTO(Integer cmsId, Integer positionId);
}
