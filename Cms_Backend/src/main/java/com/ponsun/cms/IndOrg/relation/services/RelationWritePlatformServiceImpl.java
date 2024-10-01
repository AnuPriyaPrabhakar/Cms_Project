package com.ponsun.cms.IndOrg.relation.services;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.RelationDTO;
import com.ponsun.cms.IndOrg.relation.data.RelationDataValidator;
import com.ponsun.cms.IndOrg.relation.domain.Relation;
import com.ponsun.cms.IndOrg.relation.domain.RelationRepository;
import com.ponsun.cms.IndOrg.relation.domain.RelationRepositoryWrapper;
import com.ponsun.cms.IndOrg.relation.request.CreateRelationRequest;
import com.ponsun.cms.IndOrg.relation.request.UpdateRelationRequest;
import com.ponsun.cms.IndOrg.relation.rowmapper.RelationRowMapper;
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
public class RelationWritePlatformServiceImpl implements RelationWritePlatformService {
    
    private final RelationRepository relationRepository;
    private final RelationRepositoryWrapper relationRepositoryWrapper;
    private final RelationDataValidator relationDataValidator;
    private final RelationRowMapper relationRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createRelations(CreateRelationRequest createRelationRequest) {
        try{
            this.relationDataValidator.validateSaveRelationData(createRelationRequest);
            final Relation relation = Relation.create(createRelationRequest);
            this.relationRepository.saveAndFlush(relation);
            return Response.of(relation.getId());
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateRelations(Integer id, UpdateRelationRequest updateRelationRequest) {
        try {
            this.relationDataValidator.validateUpdateRelationData(updateRelationRequest);
            final Relation relation = this.relationRepositoryWrapper.findOneWithNotFoundDetection(id);
            relation.update(updateRelationRequest);
            this.relationRepository.saveAndFlush(relation);
            return Response.of(Long.valueOf(relation.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    public List<RelationDTO> fetchRelationDTO(Integer cmsId, Integer positionId) {
        final RelationRowMapper rowMapper = new RelationRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE relation.cmsId = ?  AND positionId = ? AND relation.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<RelationDTO> relationDTOSList  = jdbcTemplate.query(Qry,relationRowMapper,
                new Object[] {cmsId,positionId}
        );
        return relationDTOSList;
    }
}
