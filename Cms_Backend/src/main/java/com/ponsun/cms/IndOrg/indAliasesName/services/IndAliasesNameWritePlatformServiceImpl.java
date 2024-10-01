package com.ponsun.cms.IndOrg.indAliasesName.services;


import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.IndAliasesNameDTO;
import com.ponsun.cms.IndOrg.indAliasesName.data.IndAliasesNameDataValidator;
import com.ponsun.cms.IndOrg.indAliasesName.domain.IndAliasesName;
import com.ponsun.cms.IndOrg.indAliasesName.domain.IndAliasesNameRepository;
import com.ponsun.cms.IndOrg.indAliasesName.domain.IndAliasesNameRepositoryWrapper;
import com.ponsun.cms.IndOrg.indAliasesName.request.CreateIndAliasesNameRequest;
import com.ponsun.cms.IndOrg.indAliasesName.request.UpdateIndAliasesNameRequest;
import com.ponsun.cms.IndOrg.indAliasesName.rowmapper.IndAliasesNameRowMapper;
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
public class IndAliasesNameWritePlatformServiceImpl implements IndAliasesNameWritePlatformService {
    private final IndAliasesNameRepository indAliasesNameRepository;
    private final IndAliasesNameRepositoryWrapper indAliasesNameRepositoryWrapper;
    private final IndAliasesNameDataValidator indAliasesNameDataValidator;
    private final IndAliasesNameRowMapper indAliasesNameRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createIndAliasesName(CreateIndAliasesNameRequest createIndAliasesNameRequest) {
        try{
            this.indAliasesNameDataValidator.validateSaveIndAliasesNameData(createIndAliasesNameRequest);
            final IndAliasesName indAliasesName = IndAliasesName.create(createIndAliasesNameRequest);
            this.indAliasesNameRepository.saveAndFlush(indAliasesName);
            return Response.of(indAliasesName.getId());
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateIndAliasesName(Integer id, UpdateIndAliasesNameRequest updateIndAliasesNameRequest) {
        try {
            this.indAliasesNameDataValidator.validateUpdateIndAliasesNameData(updateIndAliasesNameRequest);
            final IndAliasesName indAliasesName = this.indAliasesNameRepositoryWrapper.findOneWithNotFoundDetection(id);
            indAliasesName.update(updateIndAliasesNameRequest);
            this.indAliasesNameRepository.saveAndFlush(indAliasesName);
            return Response.of(Long.valueOf(indAliasesName.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<IndAliasesNameDTO> fetchIndAliasesNameDTO(Integer cmsId,Integer positionId) {
        final IndAliasesNameRowMapper rowMapper = new IndAliasesNameRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE ian.cmsId = ?  AND ian.positionId = ? AND ian.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<IndAliasesNameDTO> indAliasesNameDTOList  = jdbcTemplate.query(Qry,indAliasesNameRowMapper,
                new Object[] {cmsId ,positionId}
        );
        return indAliasesNameDTOList;
    }
}

