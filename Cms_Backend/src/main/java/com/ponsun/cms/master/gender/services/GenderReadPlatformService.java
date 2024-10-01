package com.ponsun.cms.master.gender.services;





import com.ponsun.cms.master.gender.domain.Gender;

import java.util.List;

public interface GenderReadPlatformService {

    Gender fetchGenderById(Integer id);

    List<Gender> fetchAllGender();
}
