package com.ponsun.cms.master.RelativeConfig.services;


import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.master.RelativeConfig.domain.RelativeConfig;
import com.ponsun.cms.master.RelativeConfig.domain.RelativeConfigRepository;
import com.ponsun.cms.master.RelativeConfig.domain.RelativeConfigRepositoryWrapper;
import com.ponsun.cms.master.RelativeConfig.request.CreateRelativeRequest;
import com.ponsun.cms.master.RelativeConfig.request.UpdateRelativeRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RelativeConfigWritePlatformServiceImpl implements RelativeConfigWritePlatformService {

    private final RelativeConfigRepository relativeConfigRepository;
    private final RelativeConfigRepositoryWrapper relativeConfigRepositoryWrapper;

    @Transactional
    public Response createRelative(CreateRelativeRequest createRelativeRequest) {
        try {
            final RelativeConfig relativeConfig = RelativeConfig.create(createRelativeRequest);//entity
            this.relativeConfigRepository.saveAndFlush(relativeConfig);
            return Response.of(Long.valueOf(relativeConfig.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateRelative(Integer id, UpdateRelativeRequest updateRelativeRequest) {
        try {
            RelativeConfig relativeConfig = this.relativeConfigRepositoryWrapper.findOneWithNotFoundDetection(id);
            relativeConfig.setName(updateRelativeRequest.getName());
            relativeConfig.setStatus(Status.ACTIVE);
            relativeConfig.setUpdatedAt(LocalDateTime.now());
            return Response.of(Long.valueOf(relativeConfig.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response deleteRelative(Integer id) {
        try {
            Optional<RelativeConfig> optionalRelative = relativeConfigRepository.findById(id);
            if (optionalRelative.isPresent()) {
                relativeConfigRepository.delete(optionalRelative.get());
                return Response.of(Long.valueOf(id));
            } else {
                throw new EntityNotFoundException("Country not found with ID: " + id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}