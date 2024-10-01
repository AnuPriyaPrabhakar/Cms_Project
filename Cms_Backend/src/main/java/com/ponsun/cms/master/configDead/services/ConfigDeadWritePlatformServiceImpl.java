package com.ponsun.cms.master.configDead.services;

import com.ponsun.cms.master.configDead.data.ConfigDeadDataValidator;
import com.ponsun.cms.master.configDead.domain.ConfigDead;
import com.ponsun.cms.master.configDead.domain.ConfigDeadRepository;
import com.ponsun.cms.master.configDead.domain.ConfigDeadRepositoryWrapper;
import com.ponsun.cms.master.configDead.request.CreateConfigDeadRequest;
import com.ponsun.cms.master.configDead.request.UpdateConfigDeadRequest;
import com.ponsun.cms.master.configDead.rowmapper.ConfigDeadRowMapper;
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
public class ConfigDeadWritePlatformServiceImpl implements ConfigDeadWritePlatformService {
    private final ConfigDeadRepository configDeadRepository;
    private final ConfigDeadRepositoryWrapper configDeadRepositoryWrapper;
    private final ConfigDeadDataValidator configDeadDataValidator;
    private final ConfigDeadRowMapper configDeadRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Transactional
    public Response createConfigDead(CreateConfigDeadRequest createConfigDeadRequest){
        try{
            this.configDeadDataValidator.validateSaveConfigDeadData(createConfigDeadRequest);
            final ConfigDead configDead = ConfigDead.create(createConfigDeadRequest);
            this.configDeadRepository.saveAndFlush(configDead);
            return Response.of(Long.valueOf(configDead.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateConfigDead(Integer id, UpdateConfigDeadRequest updateConfigDeadRequest) {
        try {
            this.configDeadDataValidator.validateUpdateConfigDeadData(updateConfigDeadRequest);
            final ConfigDead configDead = this.configDeadRepositoryWrapper.findOneWithNotFoundDetection(id);
            configDead.update(updateConfigDeadRequest);
            this.configDeadRepository.saveAndFlush(configDead);
            return Response.of(Long.valueOf(configDead.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockConfigDead(Integer id){
        try{
            final ConfigDead configDead = this.configDeadRepositoryWrapper.findOneWithNotFoundDetection(id);
            configDead.setStatus(Status.DELETE);
            configDead.setUpdatedAt(LocalDateTime.now());
            this.configDeadRepository.saveAndFlush(configDead);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockConfigDead(Integer id){
        try {
            final ConfigDead configDead = this.configDeadRepositoryWrapper.findOneWithNotFoundDetection(id);
            configDead.setStatus(Status.ACTIVE);
            configDead.setUpdatedAt(LocalDateTime.now());
            this.configDeadRepository.saveAndFlush(configDead);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

}
