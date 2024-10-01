package com.ponsun.cms.details.services;

import com.ponsun.cms.details.domain.Details;

import java.util.List;

public interface DetailsReadPlatformService {
    Details fetchDetailsById(Integer id );
    List<Details> fetchAllDetails();
}
