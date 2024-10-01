package com.ponsun.cms.company.commondto.services;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DetailsCombineDTO;
import com.ponsun.cms.company.commondto.dto.CompanyCombineDTO;

import java.util.List;

public interface CommonDtoReadService {

    List<CompanyCombineDTO> getCompanyDetails(Integer cmsId );
}
