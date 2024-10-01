package com.ponsun.cms.allDetails.CombinedServices.service;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DetailsCombineDTO;

import java.util.List;

public interface DetailsCombinedReadService {

    List<DetailsCombineDTO> getDetails(Integer cmsId );

}
