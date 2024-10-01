package com.ponsun.cms.allDetails.dateOfBirth.services;

import com.ponsun.cms.allDetails.dateOfBirth.domain.DateOfBirth;

import java.util.List;

public interface DateOfBirthReadPlatformService {
    DateOfBirth fetchDateOfBirthById(Integer id);

    List<DateOfBirth> fetchAllDateOfBirth();
}
