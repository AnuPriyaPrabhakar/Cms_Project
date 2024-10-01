package com.ponsun.cms.CommonAPI.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ponsun.cms.CommonAPI.DetailsReadDTO;
import com.ponsun.cms.CommonAPI.DetailsWriteDTO;
import com.ponsun.cms.infrastructure.utils.Response;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommonWriteService {
    Response saveDetails(String detailsWriteDTOS, MultipartFile[] documentfiles, Integer[] pathId,  Integer imgName);

    Response updateDetails(String detailsDTO, Integer cmsId, Integer euid, MultipartFile[] documentfiles,Integer[] pathId,Integer imgName);

    DetailsReadDTO getDetails(Integer cmsId);
}
