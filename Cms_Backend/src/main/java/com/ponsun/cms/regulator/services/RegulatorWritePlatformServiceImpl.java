package com.ponsun.cms.regulator.services;

import com.ponsun.cms.regulator.data.RegulatorDataValidator;
import com.ponsun.cms.regulator.domain.Regulator;
import com.ponsun.cms.regulator.domain.RegulatorRepository;
import com.ponsun.cms.regulator.domain.RegulatorRepositoryWrapper;
import com.ponsun.cms.regulator.request.CreateRegulatorRequest;
import com.ponsun.cms.regulator.request.UpdateRegulatorRequest;
import com.ponsun.cms.regulator.rowmapper.RegulatorRowMapper;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegulatorWritePlatformServiceImpl implements RegulatorWritePlatformService {
    private final RegulatorRepository regulatorRepository;
    private final RegulatorRepositoryWrapper regulatorRepositoryWrapper;
    private final RegulatorDataValidator regulatorDataValidator;
    private final RegulatorRowMapper addressRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Transactional
    public Response createRegulator(CreateRegulatorRequest createRegulatorRequest){
        try{
            this.regulatorDataValidator.validateSaveRegulatorData(createRegulatorRequest);
            final Regulator regulator = Regulator.create(createRegulatorRequest);
            this.regulatorRepository.saveAndFlush(regulator);
            return Response.of(Long.valueOf(regulator.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateRegulator(Integer id, UpdateRegulatorRequest updateRegulatorRequest) {
        try {
            this.regulatorDataValidator.validateUpdateRegulatorData(updateRegulatorRequest);
            final Regulator regulator = this.regulatorRepositoryWrapper.findOneWithNotFoundDetection(id);
            regulator.update(updateRegulatorRequest);
            this.regulatorRepository.saveAndFlush(regulator);
            return Response.of(Long.valueOf(regulator.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockRegulator(Integer id){
        try{
            final Regulator regulator = this.regulatorRepositoryWrapper.findOneWithNotFoundDetection(id);
            regulator.setStatus(Status.DELETE);
            regulator.setUpdatedAt(LocalDateTime.now());
            this.regulatorRepository.saveAndFlush(regulator);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockRegulator(Integer id){
        try {
            final Regulator regulator = this.regulatorRepositoryWrapper.findOneWithNotFoundDetection(id);
            regulator.setStatus(Status.ACTIVE);
            regulator.setUpdatedAt(LocalDateTime.now());
            this.regulatorRepository.saveAndFlush(regulator);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}

