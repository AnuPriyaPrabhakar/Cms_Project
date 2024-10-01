package com.ponsun.cms.caseDetails.services;


import com.ponsun.cms.caseDetails.data.CaseDetailsData;
import com.ponsun.cms.caseDetails.data.CaseDetailsDataValidator;
import com.ponsun.cms.caseDetails.domain.CaseDetails;
import com.ponsun.cms.caseDetails.domain.CaseDetailsRepository;
import com.ponsun.cms.caseDetails.domain.CaseDetailsRepositoryWrapper;
import com.ponsun.cms.caseDetails.request.CreateCaseDetailsRequest;
import com.ponsun.cms.caseDetails.request.UpdateCaseDetailsRequest;
import com.ponsun.cms.caseDetails.rowmapper.CaseDetailsRowMapper;
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
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CaseDetailsWritePlatFormServiceImpl implements CaseDetailsWritePlatFormService{

    private final CaseDetailsRepository caseDetailsRepository;
    private final CaseDetailsRepositoryWrapper caseDetailsRepositoryWrapper;
    private final CaseDetailsDataValidator caseDetailsDataValidator;
    private final CaseDetailsRowMapper caseDetailsRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Response createCaseDetails(CreateCaseDetailsRequest createCaseDetailsRequest) {
        try{
            this.caseDetailsDataValidator.validateSaveCaseDetailsData(createCaseDetailsRequest);
            final CaseDetails caseDetails = CaseDetails.create(createCaseDetailsRequest);
            this.caseDetailsRepository.saveAndFlush(caseDetails);
            return Response.of(Long.valueOf(caseDetails.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    public Response updateCaseDetails(Integer id, UpdateCaseDetailsRequest updateCaseDetailsRequest) {
        try {
            this.caseDetailsDataValidator.validateUpdateCaseDetailsData(updateCaseDetailsRequest);
            final CaseDetails caseDetails = this.caseDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            caseDetails.update(updateCaseDetailsRequest);
            this.caseDetailsRepository.saveAndFlush(caseDetails);
            return Response.of(Long.valueOf(caseDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    public List<CaseDetailsData> fetchAllCaseDetailsData(Integer cmsId) {
        final CaseDetailsRowMapper rowMapper = new CaseDetailsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE ccd.cmsId = ?  AND ccd.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<CaseDetailsData> caseDetailsDataList  = jdbcTemplate.query(Qry,caseDetailsRowMapper,
                new Object[] {cmsId}
        );
        return caseDetailsDataList;
    }

//    @Override
//    @Transactional
//    public Response deactive(Integer cmsId , Integer euid){
//        try {
//            CaseDetails caseDetailsData = this.caseDetailsRepositoryWrapper.findCmsIdNotFoundDetection(cmsId);
//            ModelMapper modelMapper = new ModelMapper();
//            CaseDetails request = modelMapper.map(caseDetailsData, CaseDetails.class);
//            request.setEuid(euid);
//            request.setStatus(Status.DELETE);
//            request.onUpdate();
//            return Response.of(request.getId());
//        } catch (DataIntegrityViolationException e){
//            throw new EQAS_CMS_AppicationException(e.getMessage());
//        }
//    }




    @Override
    @Transactional
    public Response deactive(Integer cmsId, Integer euid){
        try{
            List<CaseDetails> caseDetails = this.caseDetailsRepositoryWrapper.findCmsIdNotFoundDetection(cmsId);
            Response response = null;
            for (CaseDetails caseDetail : caseDetails) {
                caseDetail.setEuid(euid);
                caseDetail.setStatus(Status.DELETE);
                caseDetail.setUpdatedAt(LocalDateTime.now());
                response = Response.of(caseDetail.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}