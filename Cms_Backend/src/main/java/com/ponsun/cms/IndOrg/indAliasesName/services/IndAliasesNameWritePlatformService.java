package com.ponsun.cms.IndOrg.indAliasesName.services;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.IndAliasesNameDTO;
import com.ponsun.cms.IndOrg.indAliasesName.request.CreateIndAliasesNameRequest;
import com.ponsun.cms.IndOrg.indAliasesName.request.UpdateIndAliasesNameRequest;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface IndAliasesNameWritePlatformService {
    Response createIndAliasesName(CreateIndAliasesNameRequest createIndAliasesNameRequest);

    Response updateIndAliasesName(Integer id, UpdateIndAliasesNameRequest updateIndAliasesNameRequest);

    List<IndAliasesNameDTO> fetchIndAliasesNameDTO(Integer cmsId, Integer positionId);
}
