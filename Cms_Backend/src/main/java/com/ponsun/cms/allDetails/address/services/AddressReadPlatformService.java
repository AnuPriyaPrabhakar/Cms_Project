package com.ponsun.cms.allDetails.address.services;

import com.ponsun.cms.allDetails.address.domain.Address;

import java.util.List;
public interface AddressReadPlatformService {


    Address fetchAddressById(Integer id);

    List<Address> fetchAllAddress();
}
