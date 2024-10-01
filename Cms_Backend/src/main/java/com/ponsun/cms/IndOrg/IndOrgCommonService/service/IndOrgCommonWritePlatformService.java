package com.ponsun.cms.IndOrg.IndOrgCommonService.service;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.IndOrgCommonDTO;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface IndOrgCommonWritePlatformService {

    Response createIndOrgDetails(Integer cmsId, List<IndOrgCommonDTO> indOrgCommonDTOS);
    Response createAndUpdateIndOrgDetails(Integer cmsId,Integer euid, List<IndOrgCommonDTO> indOrgCommonDTOS);
}
