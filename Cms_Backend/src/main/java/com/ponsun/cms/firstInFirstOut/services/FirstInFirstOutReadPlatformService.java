package com.ponsun.cms.firstInFirstOut.services;


import com.ponsun.cms.firstInFirstOut.data.FirstInFirstOutData;

import java.util.List;

public interface FirstInFirstOutReadPlatformService {

    List<FirstInFirstOutData> getAllCustomersOrderedByIdDesc();
}
