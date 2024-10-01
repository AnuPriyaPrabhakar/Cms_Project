package com.ponsun.cms.cutomerEdit.services;



import com.ponsun.cms.cutomerEdit.data.CustomerEditData;

import java.util.List;

public interface CustomerEditWritePlatformService {

    List<CustomerEditData> fetchAllCustomerEditData(String fromDate, String toDate);
}
