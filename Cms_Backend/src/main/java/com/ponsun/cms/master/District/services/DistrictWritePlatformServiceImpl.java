package com.ponsun.cms.master.District.services;


import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.master.District.data.DistrictDataValidator;
import com.ponsun.cms.master.District.domain.District;
import com.ponsun.cms.master.District.domain.DistrictRepository;
import com.ponsun.cms.master.District.domain.DistrictRepositoryWrapper;
import com.ponsun.cms.master.District.request.CreateDistrictRequest;
import com.ponsun.cms.master.District.request.UpdateDistrictRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class DistrictWritePlatformServiceImpl implements DistrictWritePlatformService {

    private final DistrictRepository districtRepository;
    private final DistrictRepositoryWrapper districtRepositoryWrapper;
    private final DistrictDataValidator districtDataValidator;
    public Response createDistrict(CreateDistrictRequest createDistrictRequest) {
        try {
            this.districtDataValidator.validateSaveDistrict(createDistrictRequest);
            final District district = District.create(createDistrictRequest);
            this.districtRepository.saveAndFlush(district);
            return Response.of(Long.valueOf(district.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateDistrict(Integer id, UpdateDistrictRequest updateDistrictRequest) {
        try {
            this.districtDataValidator.validateUpdateDistrict(updateDistrictRequest);
            final District district = this.districtRepositoryWrapper.findOneWithNotFoundDetection(id);
            district.update(updateDistrictRequest);
            this.districtRepository.saveAndFlush(district);
            return Response.of(Long.valueOf(district.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockDistrict(Integer id) {
        try {
            final District district = this.districtRepositoryWrapper.findOneWithNotFoundDetection(id);
            district.setStatus(Status.DELETE); // Or set the appropriate status
            district.setUpdatedAt(LocalDateTime.now());
            this.districtRepository.saveAndFlush(district);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockDistrict(Integer id) {
        try {
            final District district = this.districtRepositoryWrapper.findOneWithNotFoundDetection(id);
            district.setStatus(Status.ACTIVE); // Or set the appropriate status
            district.setUpdatedAt(LocalDateTime.now());
            this.districtRepository.saveAndFlush(district);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}

