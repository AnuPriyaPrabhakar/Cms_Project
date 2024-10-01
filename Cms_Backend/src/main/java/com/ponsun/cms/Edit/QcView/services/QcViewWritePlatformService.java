package com.ponsun.cms.Edit.QcView.services;


import com.ponsun.cms.Edit.QcView.data.QcViewData;

import java.util.List;

public interface QcViewWritePlatformService {

    List<QcViewData> fetchAllQcViewData(String fromDate, String toDate);
}
