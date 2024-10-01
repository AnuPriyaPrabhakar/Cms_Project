package com.ponsun.cms.details.services;

import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.details.data.DetailsData;
import com.ponsun.cms.details.data.DetailsDataValidator;
import com.ponsun.cms.details.domain.Details;
import com.ponsun.cms.details.domain.DetailsRepository;
import com.ponsun.cms.details.domain.DetailsRepositoryWrapper;
import com.ponsun.cms.details.request.CreateDetailsRequest;
import com.ponsun.cms.details.request.UpdateDetailsRequest;
import com.ponsun.cms.details.rowmapper.DetailsRowMapper;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class DetailsWritePlatformServiceImpl implements DetailsWritePlatformService {
    private final DetailsRepository detailsRepository;
    private final DetailsRepositoryWrapper detailsRepositoryWrapper;
    private final DetailsDataValidator detailsDataValidator;
    private final DetailsRowMapper detailsRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Override
    @Transactional
    public Response createDetails(CreateDetailsRequest createDetailsRequest){
        try{
            this.detailsDataValidator.validateSaveDetailsData(createDetailsRequest);
            final Details details = Details.create(createDetailsRequest);
            this.detailsRepository.saveAndFlush(details);
            return Response.of(details.getId());
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateDetails(Integer id, UpdateDetailsRequest updateDetailsRequest) {
        try {
            this.detailsDataValidator.validateUpdateDetailsData(updateDetailsRequest);
            final Details details = this.detailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            details.update(updateDetailsRequest);
            this.detailsRepository.saveAndFlush(details);
            return Response.of(Long.valueOf(details.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response createAndUpdateDetails(CreateDetailsRequest createDetailsRequest){
        try {
            this.detailsDataValidator.validateSaveDetailsData(createDetailsRequest);
            Details existingDetails = detailsRepository.findById(createDetailsRequest.getId()).orElse(null);
            if (existingDetails != null) {
                existingDetails.setStatus(Status.DELETE);
                detailsRepository.saveAndFlush(existingDetails);
            }
            final Details details = Details.create(createDetailsRequest);
            this.detailsRepository.saveAndFlush(details);
            return Response.of(details.getId());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }



    @Override
    public List<DetailsData> fetchAllDetails(Integer id) {
        final DetailsRowMapper rowMapper = new DetailsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE cd.id = ?  AND cd.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<DetailsData> detailsDataList  = jdbcTemplate.query(Qry,detailsRowMapper,
                new Object[] {id}
        );
        return detailsDataList;
    }


}
