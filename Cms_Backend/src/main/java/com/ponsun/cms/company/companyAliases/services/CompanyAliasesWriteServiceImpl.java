package com.ponsun.cms.company.companyAliases.services;


import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.company.commondto.dto.CompanyAliasesDTO;
import com.ponsun.cms.company.companyAliases.request.UpdateCompanyAliasesRequest;
import com.ponsun.cms.company.companyAliases.data.CompanyAliasesData;
import com.ponsun.cms.company.companyAliases.data.CompanyAliasesDataValidator;
import com.ponsun.cms.company.companyAliases.domain.CompanyAliases;
import com.ponsun.cms.company.companyAliases.domain.CompanyAliasesRepository;
import com.ponsun.cms.company.companyAliases.domain.CompanyAliasesRepositoryWrapper;
import com.ponsun.cms.company.companyAliases.request.CreateCompanyAliasesRequest;
import com.ponsun.cms.company.companyAliases.rowmapper.CompanyAliasesRowMapper;
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
public class CompanyAliasesWriteServiceImpl implements CompanyAliasesWriteService {

    private final CompanyAliasesRepository companyAliasesRepository;
    private final CompanyAliasesRepositoryWrapper companyAliasesRepositoryWrapper;
    private final CompanyAliasesDataValidator companyAliasesDataValidator;
    private final CompanyAliasesRowMapper companyAliasesRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createCompanyAliases(CreateCompanyAliasesRequest createCompanyAliasesRequest) {
        try {
            final CompanyAliases companyAliases = CompanyAliases.create(createCompanyAliasesRequest);
            this.companyAliasesRepository.saveAndFlush(companyAliases);
            return Response.of(companyAliases.getUid());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateCompanyAliases(Integer id, UpdateCompanyAliasesRequest updateCompanyAliasesRequest) {
        try {
            this.companyAliasesDataValidator.validateUpdateCompanyAliasesData(updateCompanyAliasesRequest);
            final CompanyAliases companyAliases = this.companyAliasesRepositoryWrapper.findOneWithNotFoundDetection(id);
            companyAliases.update(updateCompanyAliasesRequest);
            this.companyAliasesRepository.saveAndFlush(companyAliases);
            return Response.of(Long.valueOf(companyAliases.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response deactive(Integer cmsId, Integer euid) {
        try {
            List<CompanyAliases> companyAliases = this.companyAliasesRepositoryWrapper.findCmsIdNotFoundDetection(cmsId);
            Response response = null;
            for (CompanyAliases companyAliases1 : companyAliases) {
                companyAliases1.setEuid(euid);
                companyAliases1.setStatus(Status.DELETE);
                companyAliases1.setUpdatedAt(LocalDateTime.now());
                response = Response.of(companyAliases1.getId());
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<CompanyAliasesDTO> fetchAllCompanyAliasesData(Integer cmsId , Integer companyId) {
        final CompanyAliasesRowMapper rowMapper = new CompanyAliasesRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.cmsId = ?  AND a.companyId = ?  AND a.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<CompanyAliasesDTO> companyAliasesDTOS = jdbcTemplate.query(Qry, companyAliasesRowMapper,
                new Object[] {cmsId,companyId}
        );
        return companyAliasesDTOS;
    }

}
