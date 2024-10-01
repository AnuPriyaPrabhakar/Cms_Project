package com.ponsun.cms.master.RecordType.services;

import com.ponsun.cms.master.RecordType.data.RecordTypeDataValidator;
import com.ponsun.cms.master.RecordType.domain.RecordType;
import com.ponsun.cms.master.RecordType.domain.RecordTypeRepository;
import com.ponsun.cms.master.RecordType.domain.RecordTypeRepositoryWrapper;
import com.ponsun.cms.master.RecordType.request.CreateRecordTypeRequest;
import com.ponsun.cms.master.RecordType.request.UpdateRecordTypeRequest;
import com.ponsun.cms.master.RecordType.rowmapper.RecordTypeRowMapper;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecordTypeWritePlatformServiceImpl implements RecordTypeWritePlatformService {
    private final RecordTypeRepository recordTypeRepository;
    private final RecordTypeRepositoryWrapper recordTypeRepositoryWrapper;
    private final RecordTypeDataValidator recordTypeDataValidator;
    private final RecordTypeRowMapper addressRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Transactional
    public Response createRecordType(CreateRecordTypeRequest createRecordTypeRequest){
        try{
            this.recordTypeDataValidator.validateSaveRecordType(createRecordTypeRequest);
            final RecordType recordType = RecordType.create(createRecordTypeRequest);
            this.recordTypeRepository.saveAndFlush(recordType);
            return Response.of(Long.valueOf(recordType.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateRecordType(Integer id, UpdateRecordTypeRequest updateRecordTypeRequest) {
        try {
            this.recordTypeDataValidator.validateUpdateRecordType(updateRecordTypeRequest);
            final RecordType recordType = this.recordTypeRepositoryWrapper.findOneWithNotFoundDetection(id);
            recordType.update(updateRecordTypeRequest);
            this.recordTypeRepository.saveAndFlush(recordType);
            return Response.of(Long.valueOf(recordType.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }


}
