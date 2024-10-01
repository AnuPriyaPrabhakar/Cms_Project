package com.ponsun.cms.IndOrg.detailsAboutRelation.services;


import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.DetailsAboutRelationDTO;
import com.ponsun.cms.IndOrg.detailsAboutRelation.data.DetailsAboutRelationDataValidator;
import com.ponsun.cms.IndOrg.detailsAboutRelation.domain.DetailsAboutRelation;
import com.ponsun.cms.IndOrg.detailsAboutRelation.domain.DetailsAboutRelationRepository;
import com.ponsun.cms.IndOrg.detailsAboutRelation.domain.DetailsAboutRelationRepositoryWrapper;
import com.ponsun.cms.IndOrg.detailsAboutRelation.request.CreateDetailsAboutRelationRequest;
import com.ponsun.cms.IndOrg.detailsAboutRelation.request.UpdateDetailsAboutRelationRequest;
import com.ponsun.cms.IndOrg.detailsAboutRelation.rowmapper.DetailsAboutRelationRowMapper;
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
public class DetailsAboutRelationWritePlatformServiceImpl implements DetailsAboutRelationWritePlatformService {

    private final DetailsAboutRelationRepository detailsAboutRelationRepository;
    private final DetailsAboutRelationRepositoryWrapper detailsAboutRelationRepositoryWrapper;
    private final DetailsAboutRelationDataValidator detailsAboutRelationDataValidator;
    private final DetailsAboutRelationRowMapper detailsAboutRelationRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createDetailsAboutRelation(CreateDetailsAboutRelationRequest createDetailsAboutRelationRequest) {
        try{
            this.detailsAboutRelationDataValidator.validateSaveDetailsAboutRelationData(createDetailsAboutRelationRequest);
            final DetailsAboutRelation detailsAboutRelation = DetailsAboutRelation.create(createDetailsAboutRelationRequest);
            this.detailsAboutRelationRepository.saveAndFlush(detailsAboutRelation);
            return Response.of(detailsAboutRelation.getId());
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateDetailsAboutRelation(Integer id, UpdateDetailsAboutRelationRequest updateDetailsAboutRelationRequest) {
        try {
            this.detailsAboutRelationDataValidator.validateUpdateDetailsAboutRelationData(updateDetailsAboutRelationRequest);
            final DetailsAboutRelation detailsAboutRelation = this.detailsAboutRelationRepositoryWrapper.findOneWithNotFoundDetection(id);
            detailsAboutRelation.update(updateDetailsAboutRelationRequest);
            this.detailsAboutRelationRepository.saveAndFlush(detailsAboutRelation);
            return Response.of(Long.valueOf(detailsAboutRelation.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<DetailsAboutRelationDTO> fetchDetailsAboutRelationDTO(Integer cmsId,  Integer positionId) {
        final DetailsAboutRelationRowMapper rowMapper = new DetailsAboutRelationRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE dar.cmsId = ?  AND dar.positionId = ? AND dar.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<DetailsAboutRelationDTO> DetailsAboutRelationDTOList  = jdbcTemplate.query(Qry,detailsAboutRelationRowMapper,
                new Object[] {cmsId ,positionId}
        );
        return DetailsAboutRelationDTOList;
    }
}
