package com.ponsun.cms.IndOrg.relation.services;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.RelationDTO;
import com.ponsun.cms.IndOrg.relation.request.CreateRelationRequest;
import com.ponsun.cms.IndOrg.relation.request.UpdateRelationRequest;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface RelationWritePlatformService {
    Response createRelations(CreateRelationRequest createRelationsRequest);

    Response updateRelations(Integer id, UpdateRelationRequest updateRelationsRequest);

    List<RelationDTO> fetchRelationDTO(Integer cmsId , Integer positionId);
}
