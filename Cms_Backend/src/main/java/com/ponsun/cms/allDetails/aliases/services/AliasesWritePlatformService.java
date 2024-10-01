package com.ponsun.cms.allDetails.aliases.services;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.AliasesDTO;
import com.ponsun.cms.allDetails.aliases.request.CreateAliasesRequest;
import com.ponsun.cms.allDetails.aliases.request.UpdateAliasesRequest;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface AliasesWritePlatformService {
    Response createAliases(CreateAliasesRequest createAliasesRequest);
    Response updateAliases(Integer id, UpdateAliasesRequest updateAliasesRequest);
    Response blockAliases(Integer id);
    Response unblockAliases(Integer id);

    List<AliasesDTO> fetchAllAliasesDTO(Integer cmsId);
}
