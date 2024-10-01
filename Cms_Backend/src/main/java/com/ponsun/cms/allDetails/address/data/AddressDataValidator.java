package com.ponsun.cms.allDetails.address.data;

import com.ponsun.cms.allDetails.address.request.CreateAddressRequest;
import com.ponsun.cms.allDetails.address.request.UpdateAddressRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressDataValidator {
    public void validateSaveAddressData(final CreateAddressRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
    public void validateUpdateAddressData(final UpdateAddressRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
}
