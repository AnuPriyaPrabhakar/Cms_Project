package com.ponsun.cms.allDetails.dateOfBirth.services;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DateOfBirthDTO;
import com.ponsun.cms.allDetails.dateOfBirth.request.CreateDateOfBirthRequest;
import com.ponsun.cms.allDetails.dateOfBirth.request.UpdateDateOfBirthRequest;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface DateOfBirthWritePlatformService {
    Response createDateOfBirth(CreateDateOfBirthRequest createDateOfBirthRequest);

    Response updateDateOfBirth(Integer id, UpdateDateOfBirthRequest updateAliasesNameRequest);

    List<DateOfBirthDTO> fetchAllDateOfBirthDTO(Integer cmsId);
}
