package com.ponsun.cms.allDetails.CombinedServices.service;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DetailsCombineDTO;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface DetailsCombinedWriteService {
    Response createDetail(Integer cmsId,  List<DetailsCombineDTO> detailsCombineDTO);
    Response createAndUpdateDetails(Integer cmsId, Integer euid, List<DetailsCombineDTO> detailsCombineDTO);

}
