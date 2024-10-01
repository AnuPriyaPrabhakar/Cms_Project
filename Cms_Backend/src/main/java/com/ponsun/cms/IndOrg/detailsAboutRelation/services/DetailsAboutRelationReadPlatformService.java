package com.ponsun.cms.IndOrg.detailsAboutRelation.services;

import com.ponsun.cms.IndOrg.detailsAboutRelation.domain.DetailsAboutRelation;

import java.util.List;

public interface DetailsAboutRelationReadPlatformService {
    List<DetailsAboutRelation> fetchAllDetailsAboutRelation();

    DetailsAboutRelation fetchDetailsAboutRelationById(Integer id);
}
