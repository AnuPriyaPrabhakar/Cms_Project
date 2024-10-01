package com.ponsun.cms.IndOrg.relationAliases.services;


import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.RelationAliasesDTO;
import com.ponsun.cms.IndOrg.relationAliases.request.CreateRelationAliasesRequest;
import com.ponsun.cms.IndOrg.relationAliases.request.UpdateRelationAliasesRequest;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface RelationAliasesWritePlatformService {
    Response createRelationAliases(CreateRelationAliasesRequest createRelationAliasesRequest);

    Response updateRelationAliases(Integer id, UpdateRelationAliasesRequest updateRelationAliasesRequest);

    List<RelationAliasesDTO> fetchRelationAliasesDTO(Integer cmsId, Integer positionId);
}
