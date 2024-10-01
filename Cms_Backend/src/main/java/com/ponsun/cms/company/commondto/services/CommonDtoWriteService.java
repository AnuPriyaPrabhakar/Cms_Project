package com.ponsun.cms.company.commondto.services;

import com.ponsun.cms.company.commondto.dto.CompanyCombineDTO;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface CommonDtoWriteService {
    Response createCompanyDetails(Integer cmsId, List<CompanyCombineDTO> companyCombineDTO);
    Response updateCompanyDetails(Integer cmsId, Integer euid, List<CompanyCombineDTO> companyCombineDTO);
}
