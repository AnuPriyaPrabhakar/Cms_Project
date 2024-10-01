package com.ponsun.cms.IndOrg.relationAliases.services;

import com.ponsun.cms.IndOrg.relationAliases.domain.RelationAliases;
import com.ponsun.cms.IndOrg.relationAliases.request.UpdateRelationAliasesRequest;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface RelationAliasesReadPlatformService {
    List<RelationAliases> fetchAllRelationAliases();

    RelationAliases fetchRelationAliasesById(Integer id);
}
