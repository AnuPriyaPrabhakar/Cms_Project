package com.ponsun.cms.allDetails.address.services;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.AddressDTO;
import com.ponsun.cms.allDetails.address.request.CreateAddressRequest;
import com.ponsun.cms.allDetails.address.request.UpdateAddressRequest;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;

import java.util.List;

public interface AddressWritePlatformService {


    Response createAddress(CreateAddressRequest createAddressRequest);

    Response updateAddress(Integer id, UpdateAddressRequest updateAddressRequest);

    Response blockAddress(Integer id);

    Response unblockAddress(Integer id);

    List<AddressDTO> fetchAllAddressDTO(Integer cmsId);

    Response deActivateDetails(Integer cmsId , Integer euid);
}
