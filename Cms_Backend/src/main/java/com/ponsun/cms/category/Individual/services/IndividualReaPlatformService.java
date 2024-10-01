package com.ponsun.cms.category.Individual.services;


import com.ponsun.cms.category.Individual.data.IndividualData;

import java.util.List;

public interface IndividualReaPlatformService {
    List<IndividualData> fetchAllIndividualData(String cmsName);
}
