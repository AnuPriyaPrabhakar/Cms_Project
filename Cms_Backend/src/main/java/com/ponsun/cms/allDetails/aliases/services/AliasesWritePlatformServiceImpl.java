package com.ponsun.cms.allDetails.aliases.services;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.AliasesDTO;
import com.ponsun.cms.allDetails.aliases.data.AliasesDataValidator;
import com.ponsun.cms.allDetails.aliases.domain.Aliases;
import com.ponsun.cms.allDetails.aliases.domain.AliasesRepository;
import com.ponsun.cms.allDetails.aliases.domain.AliasesRepositoryWrapper;
import com.ponsun.cms.allDetails.aliases.request.CreateAliasesRequest;
import com.ponsun.cms.allDetails.aliases.request.UpdateAliasesRequest;
import com.ponsun.cms.allDetails.aliases.rowmapper.AliasesRowMapper;
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
public class AliasesWritePlatformServiceImpl implements AliasesWritePlatformService {
    private final AliasesRepository aliasesRepository;
    private final AliasesRepositoryWrapper aliasesRepositoryWrapper;
    private final AliasesDataValidator aliasesDataValidator;
    private final AliasesRowMapper aliasesRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Transactional
    public Response createAliases(CreateAliasesRequest createAliasesRequest){
        try{
            this.aliasesDataValidator.validateSaveAliasesData(createAliasesRequest);
            final Aliases aliases = Aliases.create(createAliasesRequest);
            this.aliasesRepository.saveAndFlush(aliases);
            return Response.of(Long.valueOf(aliases.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateAliases(Integer id, UpdateAliasesRequest updateAliasesRequest){
        try{
            this.aliasesDataValidator.validateUpdateAliasesData(updateAliasesRequest);
            final Aliases aliases = this.aliasesRepositoryWrapper.findOneWithNotFoundDetection(id);
            aliases.update(updateAliasesRequest);
            this.aliasesRepository.saveAndFlush(aliases);
            return Response.of(Long.valueOf(aliases.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockAliases(Integer id){
        try{
            final Aliases aliases = this.aliasesRepositoryWrapper.findOneWithNotFoundDetection(id);
            aliases.setStatus(Status.DELETE);
            aliases.setUpdatedAt(LocalDateTime.now());
            this.aliasesRepository.saveAndFlush(aliases);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockAliases(Integer id){
        try{
            final Aliases aliases = this.aliasesRepositoryWrapper.findOneWithNotFoundDetection(id);
            aliases.setStatus(Status.ACTIVE);
            aliases.setUpdatedAt(LocalDateTime.now());
            this.aliasesRepository.saveAndFlush(aliases);
            return Response.of(Long.valueOf(id));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    public List<AliasesDTO> fetchAllAliasesDTO(Integer cmsId) {
        final AliasesRowMapper rowMapper = new AliasesRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE ca.cmsId = ?  AND ca.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<AliasesDTO> aliasesDTOSList  = jdbcTemplate.query(Qry,aliasesRowMapper,
                new Object[] {cmsId}
        );
        return aliasesDTOSList;
    }
}
