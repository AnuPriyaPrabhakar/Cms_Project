package com.ponsun.cms.IndOrg.relation.services;

import com.ponsun.cms.IndOrg.relation.domain.Relation;

import java.util.List;

public interface RelationReadPlatformService {
    List<Relation> fetchAllRelations();

    Relation fetchRelationsById(Integer id);
}
