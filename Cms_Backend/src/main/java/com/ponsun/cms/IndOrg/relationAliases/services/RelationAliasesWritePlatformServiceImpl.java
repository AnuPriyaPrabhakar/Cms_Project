package com.ponsun.cms.IndOrg.relationAliases.services;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.RelationAliasesDTO;
import com.ponsun.cms.IndOrg.relationAliases.data.RelationAliasesDataValidator;
import com.ponsun.cms.IndOrg.relationAliases.domain.RelationAliases;
import com.ponsun.cms.IndOrg.relationAliases.domain.RelationAliasesRepository;
import com.ponsun.cms.IndOrg.relationAliases.domain.RelationAliasesRepositoryWrapper;
import com.ponsun.cms.IndOrg.relationAliases.request.CreateRelationAliasesRequest;
import com.ponsun.cms.IndOrg.relationAliases.request.UpdateRelationAliasesRequest;
import com.ponsun.cms.IndOrg.relationAliases.rowmapper.RelationAliasesRowMapper;
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
public class RelationAliasesWritePlatformServiceImpl implements RelationAliasesWritePlatformService {
    private final RelationAliasesRepository relationAliasesRepository;
    private final RelationAliasesRepositoryWrapper relationAliasesRepositoryWrapper;
    private final RelationAliasesDataValidator relationAliasesDataValidator;
    private final RelationAliasesRowMapper relationAliasesRowMapper;
    private final JdbcTemplate jdbcTemplate;
    
    @Override
    @Transactional
    public Response createRelationAliases(CreateRelationAliasesRequest createRelationAliasesRequest) {
        try{
            this.relationAliasesDataValidator.validateSaveRelationAliasesData(createRelationAliasesRequest);
            final RelationAliases relationAliases = RelationAliases.create(createRelationAliasesRequest);
            this.relationAliasesRepository.saveAndFlush(relationAliases);
            return Response.of(relationAliases.getId());
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateRelationAliases(Integer id, UpdateRelationAliasesRequest updateRelationAliasesRequest) {
        try {
            this.relationAliasesDataValidator.validateUpdateRelationAliasesData(updateRelationAliasesRequest);
            final RelationAliases relationAliases = this.relationAliasesRepositoryWrapper.findOneWithNotFoundDetection(id);
            relationAliases.update(updateRelationAliasesRequest);
            this.relationAliasesRepository.saveAndFlush(relationAliases);
            return Response.of(Long.valueOf(relationAliases.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<RelationAliasesDTO> fetchRelationAliasesDTO(Integer cmsId, Integer positionId) {
        final RelationAliasesRowMapper rowMapper = new RelationAliasesRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE ran.cmsId = ?  AND ran.positionId = ? AND ran.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<RelationAliasesDTO> relationsAliasesDTOList  = jdbcTemplate.query(Qry,relationAliasesRowMapper,
                new Object[] {cmsId,positionId}
        );
        return relationsAliasesDTOList;
    }
}
