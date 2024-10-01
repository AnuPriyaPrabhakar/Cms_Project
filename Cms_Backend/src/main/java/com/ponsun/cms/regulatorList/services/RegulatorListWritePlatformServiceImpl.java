package com.ponsun.cms.regulatorList.services;

import com.ponsun.cms.regulatorList.data.RegulatorListDataValidator;
import com.ponsun.cms.regulatorList.domain.RegulatorList;
import com.ponsun.cms.regulatorList.domain.RegulatorListRepository;
import com.ponsun.cms.regulatorList.domain.RegulatorListRepositoryWrapper;
import com.ponsun.cms.regulatorList.request.CreateRegulatorListRequest;
import com.ponsun.cms.regulatorList.request.UpdateRegulatorListRequest;
import com.ponsun.cms.regulatorList.rowmapper.RegulatorListRowMapper;
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
public class RegulatorListWritePlatformServiceImpl implements RegulatorListWritePlatformService {
    private final RegulatorListRepository regulatorListRepository;
    private final RegulatorListRepositoryWrapper regulatorListRepositoryWrapper;
    private final RegulatorListDataValidator regulatorListDataValidator;
    private final RegulatorListRowMapper addressRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Transactional
    public Response createRegulatorList(CreateRegulatorListRequest createRegulatorListRequest){
        try{
            this.regulatorListDataValidator.validateSaveRegulatorList(createRegulatorListRequest);
            final RegulatorList regulatorList = RegulatorList.create(createRegulatorListRequest);
            this.regulatorListRepository.saveAndFlush(regulatorList);
            return Response.of(Long.valueOf(regulatorList.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateRegulatorList(Integer id, UpdateRegulatorListRequest updateRegulatorListRequest) {
        try {
            this.regulatorListDataValidator.validateUpdateRegulatorList(updateRegulatorListRequest);
            final RegulatorList regulatorList = this.regulatorListRepositoryWrapper.findOneWithNotFoundDetection(id);
            regulatorList.update(updateRegulatorListRequest);
            this.regulatorListRepository.saveAndFlush(regulatorList);
            return Response.of(Long.valueOf(regulatorList.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
//
    @Override
    @Transactional
    public Response blockRegulatorList(Integer id){
        try{
            final RegulatorList regulatorList = this.regulatorListRepositoryWrapper.findOneWithNotFoundDetection(id);
            regulatorList.setStatus(Status.DELETE);
            regulatorList.setUpdatedAt(LocalDateTime.now());
            this.regulatorListRepository.saveAndFlush(regulatorList);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockRegulatorList(Integer id){
        try {
            final RegulatorList regulatorList = this.regulatorListRepositoryWrapper.findOneWithNotFoundDetection(id);
            regulatorList.setStatus(Status.ACTIVE);
            regulatorList.setUpdatedAt(LocalDateTime.now());
            this.regulatorListRepository.saveAndFlush(regulatorList);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}
