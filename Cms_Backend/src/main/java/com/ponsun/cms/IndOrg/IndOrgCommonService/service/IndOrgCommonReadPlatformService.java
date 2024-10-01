package com.ponsun.cms.IndOrg.IndOrgCommonService.service;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.IndOrgCommonDTO;

import java.util.List;

public interface IndOrgCommonReadPlatformService {

    List<IndOrgCommonDTO> getIndOrgDetails(Integer cmsId );
}
