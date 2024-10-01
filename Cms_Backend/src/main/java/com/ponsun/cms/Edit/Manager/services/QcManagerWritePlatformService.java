package com.ponsun.cms.Edit.Manager.services;


import com.ponsun.cms.Edit.Manager.data.QcManagerData;

import java.util.List;

public interface QcManagerWritePlatformService {

    List<QcManagerData> fetchAllQcManagerData(String fromDate, String toDate);
}
