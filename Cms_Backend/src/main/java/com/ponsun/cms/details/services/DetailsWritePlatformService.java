package com.ponsun.cms.details.services;

import com.ponsun.cms.details.data.DetailsData;
import com.ponsun.cms.details.request.CreateDetailsRequest;
import com.ponsun.cms.details.request.UpdateDetailsRequest;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;

import java.util.List;

public interface DetailsWritePlatformService {
    Response createDetails(CreateDetailsRequest createDetailsRequest);
    Response updateDetails(Integer id, UpdateDetailsRequest updateAliasesNameRequest);

    Response createAndUpdateDetails(CreateDetailsRequest createDetailsRequest);

    List<DetailsData> fetchAllDetails(Integer id);
}
