package com.ponsun.cms.IndCaseDetails.services;


import com.ponsun.cms.IndCaseDetails.data.IndCaseDetailsData;
import com.ponsun.cms.IndCaseDetails.data.IndCaseDetailsDataValidator;
import com.ponsun.cms.IndCaseDetails.domain.IndCaseDetails;
import com.ponsun.cms.IndCaseDetails.domain.IndCaseDetailsRepository;
import com.ponsun.cms.IndCaseDetails.domain.IndIndCaseDetailsRepositoryWrapper;
import com.ponsun.cms.IndCaseDetails.request.CreateIndCaseDetailsRequest;
import com.ponsun.cms.IndCaseDetails.request.UpdateIndCaseDetailsRequest;
import com.ponsun.cms.IndCaseDetails.rowmapper.IndCaseDetailsRowMapper;
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
public class IndCaseDetailsWritePlatFormServiceImpl implements IndCaseDetailsWritePlatFormService {

    private final IndCaseDetailsRepository indCaseDetailsRepository;
    private final IndIndCaseDetailsRepositoryWrapper indCaseDetailsRepositoryWrapper;
    private final IndCaseDetailsDataValidator indCaseDetailsDataValidator;
    private final IndCaseDetailsRowMapper indCaseDetailsRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
//    public Response createIndCaseDetails(CreateIndCaseDetailsRequest createIndCaseDetailsRequest) {
//        try{
//            this.indCaseDetailsDataValidator.validateSaveCaseDetailsData(createIndCaseDetailsRequest);
//            final IndCaseDetails indCaseDetails = IndCaseDetails.create(createIndCaseDetailsRequest);
//            this.indCaseDetailsRepository.saveAndFlush(indCaseDetails);
//            return Response.of(Long.valueOf(indCaseDetails.getId()));
//        }catch (DataIntegrityViolationException e){
//            throw new EQAS_CMS_AppicationException(e.getMessage());
//        }
//    }

    public Response createIndCaseDetails(CreateIndCaseDetailsRequest createIndCaseDetailsRequest) {
        try {
            final IndCaseDetails indCaseDetails = IndCaseDetails.create(createIndCaseDetailsRequest);
            this.indCaseDetailsRepository.saveAndFlush(indCaseDetails);
            return Response.of(indCaseDetails.getUid());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }


    @Override
    @Transactional
    public Response updateIndCaseDetails(Integer id, UpdateIndCaseDetailsRequest updateIndCaseDetailsRequest) {
        try {
            this.indCaseDetailsDataValidator.validateUpdateCaseDetailsData(updateIndCaseDetailsRequest);
            final IndCaseDetails indCaseDetails = this.indCaseDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            indCaseDetails.update(updateIndCaseDetailsRequest);
            this.indCaseDetailsRepository.saveAndFlush(indCaseDetails);
            return Response.of(Long.valueOf(indCaseDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<IndCaseDetailsData> fetchAllCaseDetailsData(Integer cmsId) {
        final IndCaseDetailsRowMapper rowMapper = new IndCaseDetailsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE cd.cmsId = ?  AND cd.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<IndCaseDetailsData> indCaseDetailsDataList = jdbcTemplate.query(Qry, indCaseDetailsRowMapper,
                new Object[] {cmsId}
        );
        return indCaseDetailsDataList;
    }

    @Override
    @Transactional
    public Response deactive(Integer cmsId, Integer euid){
        try{
            List<IndCaseDetails> indCaseDetails = this.indCaseDetailsRepositoryWrapper.findCmsIdNotFoundDetection(cmsId);
            Response response = null;
            for (IndCaseDetails caseDetail : indCaseDetails) {
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