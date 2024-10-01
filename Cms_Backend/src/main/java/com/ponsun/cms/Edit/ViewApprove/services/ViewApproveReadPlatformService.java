package com.ponsun.cms.Edit.ViewApprove.services;


import com.ponsun.cms.Edit.ViewApprove.data.ViewApproveData;

import java.util.List;

public interface ViewApproveReadPlatformService {

    List<ViewApproveData> fetchAllViewApproveData(String fromDate, String toDate);
}
