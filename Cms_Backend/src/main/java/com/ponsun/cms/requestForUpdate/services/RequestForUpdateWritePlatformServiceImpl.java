package com.ponsun.cms.requestForUpdate.services;


import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.requestForUpdate.data.RequestForUpdateDataValidator;
import com.ponsun.cms.requestForUpdate.domain.RequestForUpdate;
import com.ponsun.cms.requestForUpdate.domain.RequestForUpdateRepository;
import com.ponsun.cms.requestForUpdate.domain.RequestForUpdateRepositoryWrapper;
import com.ponsun.cms.requestForUpdate.request.CreateRequestForUpdateRequest;
import com.ponsun.cms.requestForUpdate.request.UpdateRequestForUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RequestForUpdateWritePlatformServiceImpl implements RequestForUpdateWritePlatformService{


    private final RequestForUpdateRepository requestForUpdateRepository;
    private final RequestForUpdateRepositoryWrapper requestForUpdateRepositoryWrapper;
    private final RequestForUpdateDataValidator requestForUpdateDataValidator;


    @Override
    public Response createRequestForUpdateRequest(CreateRequestForUpdateRequest createRequestForUpdateRequest) {
        try {
            this.requestForUpdateDataValidator.validateSaveRequestForUpdate(createRequestForUpdateRequest);
            final RequestForUpdate requestForUpdate = RequestForUpdate.create(createRequestForUpdateRequest);
            this.requestForUpdateRepository.saveAndFlush(requestForUpdate);
            return Response.of(Long.valueOf(requestForUpdate.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateRequestForUpdate(Integer id, UpdateRequestForUpdateRequest updateRequestForUpdateRequest){
        try{
            this.requestForUpdateDataValidator.validateUpdateRequestForUpdate(updateRequestForUpdateRequest);
            final RequestForUpdate requestForUpdate = this.requestForUpdateRepositoryWrapper.findOneWithNotFoundDetection(id);
            requestForUpdate.update(updateRequestForUpdateRequest);
            this.requestForUpdateRepository.saveAndFlush(requestForUpdate);
            return Response.of(Long.valueOf(requestForUpdate.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}
