package com.ponsun.cms.RequestDescription.services;



import com.ponsun.cms.RequestDescription.domain.RequestDescription;

import java.util.List;

public interface RequestDescriptionReadPlatformService {
    RequestDescription fetchRequestDescriptionById(Integer id);
    List<RequestDescription> fetchAllRequestDescription();
}
