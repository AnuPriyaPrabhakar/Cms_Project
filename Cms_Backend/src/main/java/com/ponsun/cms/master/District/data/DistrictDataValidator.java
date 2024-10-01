package com.ponsun.cms.master.District.data;

import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.master.District.request.CreateDistrictRequest;
import com.ponsun.cms.master.District.request.UpdateDistrictRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DistrictDataValidator {
    public void validateSaveDistrict(final CreateDistrictRequest request) {
        if (request.getCityName() == null || request.getCityName().equals("")) {
            throw new EQAS_CMS_ApplicationException("CityName parameter required");
        }
    }
    public void validateUpdateDistrict(final UpdateDistrictRequest request) {
        if (request.getCityName() == null || request.getCityName().equals("")) {
            throw new EQAS_CMS_ApplicationException("CityName parameter required");
        }
    }
}